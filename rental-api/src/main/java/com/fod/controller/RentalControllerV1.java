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

import com.fod.model.Rental;
import com.fod.service.RentalService;

@RestController
@RequestMapping("/api/v1")
public class RentalControllerV1 {
    private static final Logger logger = LoggerFactory.getLogger(RentalControllerV1.class);
    
    @Autowired
    private RentalService rentalService;

    @GetMapping("/rental/{id}")
    public Optional<Rental> getRentalById(@PathVariable("id") Integer id) {
        logger.debug("Get rental {}", id);
        Optional<Rental> entity = rentalService.findById(id);
        if (entity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return entity;
    }

    @GetMapping("/rentals")
    public List<Rental> getRentals(@RequestParam Map<String, String> params) {
        if (params.size() == 0) {
            // Query all rentals - don't throw NOT_FOUND exception
            List<Rental> entities = rentalService.findAll();
            return entities;

        } else if (params.size() > 1) {
            // Too many parameters
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too many parameters");

        } else if (params.containsKey("customer_id")) {
            // Query by customer
            int value;
            try {
                value = Integer.parseInt(params.get("customer_id"));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid customer parameter");
            }
            logger.debug("Finding rental param customer_id: {}", value);
            List<Rental> entities = rentalService.findByCustomerId(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;

        } else if (params.containsKey("inventory_id")) {
            // Query by inventory
            int value;
            try {
                value = Integer.parseInt(params.get("inventory_id"));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid inventory parameter");
            }
            logger.debug("Finding rental param inventory_id: {}", value);
            List<Rental> entities = rentalService.findByInventoryId(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid query parameter");
    }
}
