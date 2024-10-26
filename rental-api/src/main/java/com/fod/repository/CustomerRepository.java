package com.fod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fod.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
    @Query("SELECT c FROM Customer c WHERE c.store_id = :store_id")
    List<Customer> findByStoreId(@Param("store_id") Integer store_id);

    @Query("SELECT c FROM Customer c WHERE c.last_name = :last_name")
    List<Customer> findByLastName(@Param("last_name") String last_name);

    @Query("SELECT c FROM Customer c WHERE c.last_name LIKE :last_name")
    List<Customer> findByLastNameLike(@Param("last_name") String last_name);
}
