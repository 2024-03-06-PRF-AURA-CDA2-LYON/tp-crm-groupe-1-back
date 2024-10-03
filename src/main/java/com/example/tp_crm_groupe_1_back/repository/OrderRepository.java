package com.example.tp_crm_groupe_1_back.repository;

import com.example.tp_crm_groupe_1_back.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findById(long id);
}
