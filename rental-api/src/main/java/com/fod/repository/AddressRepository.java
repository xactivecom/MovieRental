package com.fod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fod.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    
    @Query("SELECT a FROM Address a WHERE a.city_id = :city_id")
    List<Address> findByCityId(@Param("city_id") Integer city_id);
}
