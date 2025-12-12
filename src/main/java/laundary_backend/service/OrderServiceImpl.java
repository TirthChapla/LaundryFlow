package laundary_backend.service;

import laundary_backend.entity.Item;
import laundary_backend.entity.Order;
import laundary_backend.enums.Status;
import laundary_backend.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OrderServiceImpl implements OrderService
{
    Logger log = Logger.getLogger(OrderServiceImpl.class.getName());

    OrderRepo orderRepo;

/// Constructor  Injection
    public OrderServiceImpl(OrderRepo orderRepo)
    {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order createOrder(Order order)
    {
        log.log(Level.INFO, "Creating Order");

        // Set parent reference
        if(order.getItems() != null) {
            for(Item item : order.getItems()) {
                item.setOrder(order);
            }
        }

        if(order.getServices() != null) {
            for(laundary_backend.entity.Service service : order.getServices()) {
                service.setOrder(order);
            }
        }

        Order savedOrder = orderRepo.save(order);

        log.log(Level.INFO, "Order Created with ID: " + savedOrder.getOrderId());

        return savedOrder;
    }


    @Override
    public List<Order> getAllOrders()
    {
        log.log(Level.INFO, "Getting All Orders");
        List<Order> orders = orderRepo.findAll();
        log.log(Level.INFO, "Total Orders Found: " + orders.size());
        return orders;

    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public void deleteOrder(Long orderId) {
        if (!orderRepo.existsById(orderId)) {
            throw new RuntimeException("Order not found");
        }
        orderRepo.deleteById(orderId);
    }

    @Override
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        /// for the Status we are using Enum
        order.setStatus(Status.valueOf(status));

        return orderRepo.save(order);
    }

}
