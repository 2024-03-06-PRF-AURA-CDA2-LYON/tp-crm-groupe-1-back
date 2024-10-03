package com.example.tp_crm_groupe_1_back.controller;

import com.example.tp_crm_groupe_1_back.model.Customer;
import com.example.tp_crm_groupe_1_back.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customer1 = customerRepository.findById(id);
        if (customer1.isPresent()) {
            customer.setId(id);
            customer.setCompanyName(customer.getCompanyName());
            customer.setFirstName(customer.getFirstName());
            customer.setLastName(customer.getLastName());
            customer.setEmail(customer.getEmail());
            customer.setPhoneNumber(customer.getPhoneNumber());
            customer.setAddress(customer.getAddress());
            customer.setZipCode(customer.getZipCode());
            customer.setCountry(customer.getCountry());
            customer.setCity(customer.getCity());
            customer.setState(customer.getState());
            customerRepository.save(customer);
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
            return ResponseEntity.ok(customer.get());
        }
        return ResponseEntity.notFound().build();
    }


}
