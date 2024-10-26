package com.fod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fod.model.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    
    @Query("SELECT s FROM Store s WHERE s.address_id = :address_id")
    List<Store> findByAddressId(@Param("address_id") Integer address_id);
}
