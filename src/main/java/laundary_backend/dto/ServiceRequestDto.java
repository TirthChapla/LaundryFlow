package laundary_backend.dto;

import lombok.Data;

@Data
public class ServiceRequestDto {

    private String name;     // Washing, Ironing
    private double price;
}
