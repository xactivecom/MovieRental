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

import com.fod.model.Staff;
import com.fod.service.StaffService;

@RestController
@RequestMapping("/api/v1")
public class StaffControllerV1 {

    private static final Logger logger = LoggerFactory.getLogger(StaffControllerV1.class);

    @Autowired
    private StaffService staffService;

    @GetMapping("/staff/{id}")
    public Optional<Staff> getCustomerById(@PathVariable("id") Integer id) {
        logger.debug("Get staff {}", id);
        Optional<Staff> entity = staffService.findById(id);
        if (entity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return entity;
    }

    @GetMapping("/staff")
    public List<Staff> getAllCustomers(@RequestParam Map<String, String> params) {
        if (params.size() == 0) {
            // Query all staff - don't throw NOT_FOUND exception
            List<Staff> entities = staffService.findAll();
            return entities;

        } else if (params.size() > 1) {
            // Too many parameters
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too many parameters");

        } else if (params.containsKey("last_name")) {
            // Query by last name
            String value = params.get("last_name").trim();
            logger.debug("Finding staff param last_name: {}", value);
            List<Staff> entities = staffService.findByLastName(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;

        } else if (params.containsKey("store_id")) {
            // Query by release year
            int value;
            try {
                value = Integer.parseInt(params.get("store_id"));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid store parameter");
            }
            logger.debug("Finding staff param store_id: {}", value);
            List<Staff> entities = staffService.findByStoreId(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid query parameter");
    }
}
