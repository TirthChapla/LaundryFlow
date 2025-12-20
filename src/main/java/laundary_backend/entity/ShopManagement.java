package laundary_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="shop_management")
public class ShopManagement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopManagementId;

    @OneToOne
    @JoinColumn(name = "shop_sid")
    Shop sid;







}
