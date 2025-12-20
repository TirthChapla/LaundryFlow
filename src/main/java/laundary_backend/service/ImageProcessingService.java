package laundary_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImageProcessingService {

    private static final String PYTHON_EXE =
            "C:\\Users\\tirth\\AppData\\Local\\Programs\\Python\\Python311\\python.exe";

    private static final String PYTHON_SCRIPT =
            "python\\process_image.py";

    // ✅ PORTABLE BASE DIRECTORY
    private static final String BASE_DIR =
            System.getProperty("user.home") + "\\laundry-storage";

    private static final String UPLOAD_DIR = BASE_DIR + "\\uploads";
    private static final String OUTPUT_DIR = BASE_DIR + "\\outputs";

    /* ===================== MultipartFile ===================== */
    public File processImage(MultipartFile file , String type) throws Exception {

        new File(UPLOAD_DIR).mkdirs();
        new File(OUTPUT_DIR).mkdirs();

        File inputFile = new File(
                UPLOAD_DIR,
                type+"_"+System.currentTimeMillis() + "_" + file.getOriginalFilename()
        );

        file.transferTo(inputFile);

        return processImage(inputFile);
    }

    /* ===================== File ===================== */
    public File processImage(File inputFile) throws Exception {

        new File(OUTPUT_DIR).mkdirs();

        File outputFile = new File(
                OUTPUT_DIR,
                "final_" + System.currentTimeMillis() + ".jpg"
        );

        ProcessBuilder pb = new ProcessBuilder(
                PYTHON_EXE,
                PYTHON_SCRIPT,
                inputFile.getAbsolutePath(),
                outputFile.getAbsolutePath()
        );

        pb.redirectErrorStream(true);
        Process process = pb.start();

        int exitCode = process.waitFor();

        if (exitCode != 0 || !outputFile.exists()) {
            throw new RuntimeException("Python image processing failed");
        }

        return outputFile;
    }
}
