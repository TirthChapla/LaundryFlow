package laundary_backend.controllers;

import laundary_backend.entity.Order;
import laundary_backend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Add Order
    @PostMapping()
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {

        double itemPrice = 0.0;
        int totalItems = 0;

        for (var item : order.getItems()) {
            totalItems += item.getCount();
            itemPrice += item.getCount() * item.getPrice();
        }

        for (var service : order.getServices()) {
            itemPrice += totalItems * service.getPrice();
        }

        order.setTotalAmount(itemPrice);
        Order savedOrder = orderService.createOrder(order);

        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
    }

    // Track All Orders
    @GetMapping("/track-order")
    public ResponseEntity<List<Order>> trackOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Get Order By ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // Delete Order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
    }

    // Update Order Status
    @PutMapping("/{orderId}/status/{status}")
    public ResponseEntity<Order> updateOrderStatus(
            @PathVariable Long orderId,
            @PathVariable String status
    ) {
        Order updatedOrder = orderService.updateOrderStatus(orderId, status);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }
}

