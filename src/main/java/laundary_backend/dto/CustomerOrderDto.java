package laundary_backend.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import laundary_backend.entity.Item;
import laundary_backend.entity.Service;
import laundary_backend.enums.Status;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
public class CustomerOrderDto {

    private List<Item> items;

    private long cid;
    private long sid;

    private List<Service> services;

    private Status status = Status.PLACED;

    private Date orderDate;

    private String address;
    private String specialInstructions;

    // images from Postman / frontend
    private List<MultipartFile> images;
}
