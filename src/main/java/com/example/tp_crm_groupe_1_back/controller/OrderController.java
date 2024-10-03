package com.example.tp_crm_groupe_1_back.controller;

import com.example.tp_crm_groupe_1_back.model.Order;
import com.example.tp_crm_groupe_1_back.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    

    @GetMapping
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Optional<Order> existingOrderOpt = orderRepository.findById(id);
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();

            existingOrder.setServiceType(order.getServiceType());
            existingOrder.setNbDays(order.getNbDays());
            existingOrder.setTva(order.getTva());
            existingOrder.setTotalExcludeTax(order.getTotalExcludeTax());
            existingOrder.setState(order.getState());
            existingOrder.setComment(order.getComment());

            orderRepository.save(existingOrder);
            return ResponseEntity.ok(existingOrder);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.delete(order.get());
            return ResponseEntity.ok(order.get());
        }
        return ResponseEntity.notFound().build();
    }
    
}
