package web.controller;

import entity.Order;
import entity.DTO.OrderDTO;
import entity.Engine;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createProduct(@RequestBody Order order) {
        Order newProduct = orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/{сlientId}")
    public ResponseEntity<OrderDTO> getProductById(@PathVariable Long orderId) {
        return orderService.findById(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllProducts() {
        List<OrderDTO> products = orderService.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{Orderid}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{Orderid}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order updatedProduct = orderService.update(id, order);
        return ResponseEntity.ok(updatedProduct);
    }
}
