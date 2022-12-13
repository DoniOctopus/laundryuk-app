package com.enigma.laundryuk.service.impl;

import com.enigma.laundryuk.entity.Customer;
import com.enigma.laundryuk.repository.CustomerRepository;
import com.enigma.laundryuk.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setCreatedAt(new Date());
        customer.setUpdatedAt(new Date());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customer.setUpdatedAt(new Date());
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getAllCustomer(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}