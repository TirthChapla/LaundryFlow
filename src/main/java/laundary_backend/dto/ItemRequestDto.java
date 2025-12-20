package laundary_backend.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ItemRequestDto {

    private String name;      // Shirt, Pant, Jacket...
    private int count;
    private double price;

    private List<MultipartFile> images;
}
