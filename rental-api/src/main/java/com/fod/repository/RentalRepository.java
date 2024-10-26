package com.fod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fod.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    
    @Query("SELECT r FROM Rental r WHERE r.customer_id = :customer_id")
    List<Rental> findByCustomerId(@Param("customer_id") Integer customer_id);

    @Query("SELECT r FROM Rental r WHERE r.inventory_id = :inventory_id")
    List<Rental> findByInventoryId(@Param("inventory_id") Integer inventory_id);
}
