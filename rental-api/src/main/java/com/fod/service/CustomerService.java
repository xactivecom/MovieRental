package com.fod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fod.model.Customer;
import com.fod.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findByStoreId(Integer store_id) {
        return customerRepository.findByStoreId(store_id);
    }

    public List<Customer> findByLastName(String last_name) {
        if (last_name.indexOf("*") > 0) {
            last_name = last_name.replaceAll("\\*", "%");
            return customerRepository.findByLastNameLike(last_name);
        } else {
            return customerRepository.findByLastName(last_name);
        }
    }
}
