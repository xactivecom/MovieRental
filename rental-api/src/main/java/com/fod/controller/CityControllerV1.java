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

import com.fod.model.City;
import com.fod.service.CityService;

@RestController
@RequestMapping("/api/v1")
public class CityControllerV1 {

    private static final Logger logger = LoggerFactory.getLogger(CityControllerV1.class);

    @Autowired
    private CityService cityService;

    @GetMapping("/city/{id}")
    public Optional<City> getStoreById(@PathVariable("id") Integer id) {
        logger.debug("Get city {}", id);
        Optional<City> entity = cityService.findById(id);
        if (entity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return entity;
    }

    @GetMapping("/cities")
    public List<City> getCities(@RequestParam Map<String, String> params) {
        if (params.size() == 0) {
            // Query all cities - don't throw NOT_FOUND exception
            List<City> entities = cityService.findAll();
            return entities;

        } else if (params.size() > 1) {
            // Too many parameters
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too many parameters");

        } else if (params.containsKey("city")) {
            // Query by city
            String value = params.get("city").trim();
            logger.debug("Finding city param city: {}", value);
            List<City> entities = cityService.findByCity(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid query parameter");
    }
}
