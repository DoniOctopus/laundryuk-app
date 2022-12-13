package com.enigma.laundryuk.controller;

import com.enigma.laundryuk.entity.Customer;
import com.enigma.laundryuk.entity.Product;
import com.enigma.laundryuk.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Page<Customer> getCustomers(){
        return customerService.getAllCustomer(0,10);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer product){
        return customerService.updateCustomer(product);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }
}