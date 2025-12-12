package laundary_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Data
@Table(name ="item")
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;


    String name;

    int count;

    double price;

    @ManyToOne
    @JoinColumn(name ="orderId")
    @JsonIgnore         // to avoid circular loop
    Order order;

    @ElementCollection
    private List<String> images;

}
