package com.example.tp_crm_groupe_1_back.repository;

import com.example.tp_crm_groupe_1_back.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findById(long id);
}
