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

import com.fod.model.Store;
import com.fod.service.StoreService;

@RestController
@RequestMapping("/api/v1")
public class StoreControllerV1 {
    private static final Logger logger = LoggerFactory.getLogger(StoreControllerV1.class);

    @Autowired
    private StoreService storeService;

    @GetMapping("/store/{id}")
    public Optional<Store> getStoreById(@PathVariable("id") Integer id) {
        logger.debug("Get store {}", id);
        Optional<Store> entity = storeService.findById(id);
        if (entity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return entity;
    }

    @GetMapping("/stores")
    public List<Store> getStores(@RequestParam Map<String, String> params) {
        if (params.size() == 0) {
            // Query all stores - don't throw NOT_FOUND exception
            List<Store> entities = storeService.findAll();
            return entities;

        } else if (params.size() > 1) {
            // Too many parameters
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too many parameters");

        } else if (params.containsKey("address_id")) {
            // Query by address
            int value;
            try {
                value = Integer.parseInt(params.get("address_id"));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid address parameter");
            }
            logger.debug("Finding store param address_id: {}", value);
            List<Store> entities = storeService.findByAddressId(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid query parameter");
    }
}
