package laundary_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name ="service")
@Data
public class Service
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long serviceid;

    @ManyToOne
    @JoinColumn(name ="orderId")
    @JsonIgnore        // to avoid circular loop
    Order order;

    String name;

    double price;
}
