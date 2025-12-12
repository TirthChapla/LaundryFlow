package laundary_backend.service;

import laundary_backend.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService
{
    Order createOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

    void deleteOrder(Long orderId);

    Order updateOrderStatus(Long orderId, String status);
}
