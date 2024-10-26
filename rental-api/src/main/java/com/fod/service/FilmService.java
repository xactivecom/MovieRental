package com.fod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fod.model.Film;
import com.fod.repository.FilmRepository;

@Service
public class FilmService {
    
    @Autowired
    private FilmRepository filmRepository;

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Optional<Film> findById(Integer id) {
        return filmRepository.findById(id);
    }

    public List<Film> findByTitle(String title) {
        // Film names are uppercase
        if (title != null) title = title.toUpperCase();
        
        if (title.indexOf("*") > 0) {
            title = title.replaceAll("\\*", "%");
            return filmRepository.findByTitleLike(title);
        } else {
            return filmRepository.findByTitle(title);
        }
    }

    public List<Film> findByReleaseYear(Integer year) {
        return filmRepository.findByReleaseYear(year);
    }
}
