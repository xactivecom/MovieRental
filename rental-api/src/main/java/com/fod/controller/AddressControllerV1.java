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

import com.fod.model.Address;
import com.fod.service.AddressService;

@RestController
@RequestMapping("/api/v1")
public class AddressControllerV1 {

    private static final Logger logger = LoggerFactory.getLogger(AddressControllerV1.class);
    
    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{id}")
    public Optional<Address> getAddressById(@PathVariable("id") Integer id) {
        logger.debug("Get address {}", id);
        Optional<Address> entity = addressService.findById(id);
        if (entity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return entity;
    }

    @GetMapping("/addresses")
    public List<Address> getAddresses(@RequestParam Map<String, String> params) {
        if (params.size() == 0) {
            // Query all customers - don't throw NOT_FOUND exception
            List<Address> entities = addressService.findAll();
            return entities;

        } else if (params.size() > 1) {
            // Too many parameters
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too many parameters");

        } else if (params.containsKey("city_id")) {
            // Query by city
            int value;
            try {
                value = Integer.parseInt(params.get("city_id"));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid city parameter");
            }
            logger.debug("Finding address param city: {}", value);
            List<Address> entities = addressService.findByCityId(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid query parameter");
    }
}
