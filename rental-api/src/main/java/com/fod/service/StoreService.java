package com.fod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fod.model.Store;
import com.fod.repository.StoreRepository;

@Service
public class StoreService {
    
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Optional<Store> findById(Integer id) {
        return storeRepository.findById(id);
    }

    public List<Store> findByAddressId(Integer address_id) {
        return storeRepository.findByAddressId(address_id);
    }
}
