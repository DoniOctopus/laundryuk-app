package com.enigma.laundryuk.service;

import com.enigma.laundryuk.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer product);
    Customer updateCustomer(Customer product);
    Page<Customer> getAllCustomer(int page, int size);
    Customer getCustomerById(String productId);
    void deleteCustomer(String id);
}
