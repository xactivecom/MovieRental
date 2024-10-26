package com.fod.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fod.model.Category;
import com.fod.service.CategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")
    public Optional<Category> getCategoryById(@PathVariable("id") Integer id) {
        Optional<Category> entity = categoryService.findById(id);
        if (entity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return entity;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        List<Category> entities = categoryService.findAll();
        return entities;
    }
}
