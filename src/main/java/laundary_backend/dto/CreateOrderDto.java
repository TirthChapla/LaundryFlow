package laundary_backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {

    private long cid;
    private long sid;

    private List<ItemRequestDto> items;
    private List<ServiceRequestDto> services;

    private String address;
    private String specialInstructions;

}
