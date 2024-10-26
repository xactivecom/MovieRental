package com.fod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fod.model.Rental;
import com.fod.repository.RentalRepository;

@Service
public class RentalService {
    
    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> findById(Integer id) {
        return rentalRepository.findById(id);
    }

    public List<Rental> findByCustomerId(Integer customer_id) {
        return rentalRepository.findByCustomerId(customer_id);
    }

    public List<Rental> findByInventoryId(Integer inventory_id) {
        return rentalRepository.findByInventoryId(inventory_id);
    }
}
