package laundary_backend.Cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import laundary_backend.service.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class CloudService implements CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    // existing method (keep it)
    @Override
    public String uploadToCloudinary(MultipartFile file) {
        try {
            String publicId = UUID.randomUUID().toString();

            Map<String, Object> options = ObjectUtils.asMap(
                    "folder", "laundry/orders",
                    "public_id", publicId
            );

            cloudinary.uploader().upload(file.getBytes(), options);

            return cloudinary.url()
                    .secure(true)
                    .transformation(
                            new Transformation<>()
                                    .width(500)
                                    .height(500)
                                    .crop("fill")
                    )
                    .generate("laundry/orders/" + publicId);

        } catch (IOException e) {
            throw new RuntimeException("Image upload failed");
        }
    }

    // ✅ NEW: upload processed file
    public String uploadProcessedFile(File file) {
        try {
            String publicId = UUID.randomUUID().toString();

            Map<String, Object> options = ObjectUtils.asMap(
                    "folder", "laundry/orders",
                    "public_id", publicId
            );

            cloudinary.uploader().upload(file, options);

            return cloudinary.url()
                    .secure(true)
                    .transformation(
                            new Transformation<>()
                                    .width(500)
                                    .height(500)
                                    .crop("fill")
                    )
                    .generate("laundry/orders/" + publicId);

        } catch (IOException e) {
            throw new RuntimeException("Processed image upload failed");
        }
    }
}



