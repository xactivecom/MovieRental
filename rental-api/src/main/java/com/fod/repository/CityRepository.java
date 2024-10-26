package com.fod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fod.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {
    
    @Query("SELECT c FROM City c WHERE c.city = :city")
    List<City> findByCity(@Param("city") String city);

    @Query("SELECT c FROM City c WHERE c.city LIKE :city")
    List<City> findByCityLike(@Param("city") String city);
}
