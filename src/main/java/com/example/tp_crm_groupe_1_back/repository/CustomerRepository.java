package com.example.tp_crm_groupe_1_back.repository;

import com.example.tp_crm_groupe_1_back.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
