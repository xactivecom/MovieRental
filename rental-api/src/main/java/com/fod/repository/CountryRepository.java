package com.fod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fod.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    
}
