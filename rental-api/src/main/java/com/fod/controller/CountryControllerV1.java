package com.fod.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fod.model.Country;
import com.fod.service.CountryService;

@RestController
@RequestMapping("/api/v1")
public class CountryControllerV1 {
    
    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{id}")
    public Optional<Country> getStoreById(@PathVariable("id") Integer id) {
        Optional<Country> entity = countryService.findById(id);
        if (entity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return entity;
    }

    @GetMapping("/countries")
    public List<Country> getAllStores() {
        List<Country> entities = countryService.findAll();
        return entities;
    }
}
