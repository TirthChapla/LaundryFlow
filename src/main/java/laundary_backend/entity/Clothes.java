package laundary_backend.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clothes")
@Data
public class Clothes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clothId;

    private String clothName;
    private String clothType;
    private String clothPrice;


}
