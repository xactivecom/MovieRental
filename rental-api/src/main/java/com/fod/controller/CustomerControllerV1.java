package com.fod.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fod.model.Customer;
import com.fod.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerControllerV1 {

    private static final Logger logger = LoggerFactory.getLogger(CustomerControllerV1.class);
    
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") Integer id) {
        logger.debug("Get customer {}", id);
        Optional<Customer> entity = customerService.findById(id);
        if (entity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return entity;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(@RequestParam Map<String, String> params) {
        if (params.size() == 0) {
            // Query all customers - don't throw NOT_FOUND exception
            List<Customer> entities = customerService.findAll();
            return entities;

        } else if (params.size() > 1) {
            // Too many parameters
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too many parameters");

        } else if (params.containsKey("last_name")) {
            // Query by last name
            String value = params.get("last_name").trim();
            logger.debug("Finding customer param last_name: {}", value);
            List<Customer> entities = customerService.findByLastName(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;

        } else if (params.containsKey("store_id")) {
            // Query by store
            int value;
            try {
                value = Integer.parseInt(params.get("store_id"));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid store parameter");
            }
            logger.debug("Finding customer param store_id: {}", value);
            List<Customer> entities = customerService.findByStoreId(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid query parameter");
    }
}
