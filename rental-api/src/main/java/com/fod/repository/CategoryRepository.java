package com.fod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fod.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
