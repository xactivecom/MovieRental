package com.fod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fod.model.Address;
import com.fod.repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> findById(Integer id) {
        return addressRepository.findById(id);
    }

    public List<Address> findByCityId(Integer city_id) {
        return addressRepository.findByCityId(city_id);
    }
}
