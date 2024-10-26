package com.fod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fod.model.City;
import com.fod.repository.CityRepository;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public Optional<City> findById(Integer id) {
        return cityRepository.findById(id);
    }

    public List<City> findByCity(String city) {
        if (city.indexOf("*") > 0) {
            city = city.replaceAll("\\*", "%");
            return cityRepository.findByCityLike(city);
        } else {
            return cityRepository.findByCity(city);
        }
    }
}
