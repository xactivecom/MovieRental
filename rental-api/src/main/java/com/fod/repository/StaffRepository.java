package com.fod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fod.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    
    @Query("SELECT s FROM Staff s WHERE s.store_id = :store_id")
    List<Staff> findByStoreId(@Param("store_id") Integer store_id);

    @Query("SELECT s FROM Staff s WHERE s.last_name = :last_name")
    List<Staff> findByLastName(@Param("last_name") String last_name);

    @Query("SELECT s FROM Staff s WHERE s.last_name LIKE :last_name")
    List<Staff> findByLastNameLike(@Param("last_name") String last_name);
}
