package laundary_backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    String uploadToCloudinary(MultipartFile file);
}
