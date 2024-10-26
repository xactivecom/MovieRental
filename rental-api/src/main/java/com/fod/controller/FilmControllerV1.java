package com.fod.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fod.model.Film;
import com.fod.service.FilmService;

@RestController
@RequestMapping("/api/v1")
public class FilmControllerV1 {

    private static final Logger logger = LoggerFactory.getLogger(FilmControllerV1.class);

    @Autowired
    private FilmService filmService;
    
    @GetMapping("/film/{id}")
    public Optional<Film> getFilmById(@PathVariable("id") Integer id) {
        Optional<Film> entity = filmService.findById(id);
        if (entity.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return entity;
    }

    @GetMapping("/films")
    public List<Film> getFilms(@RequestParam Map<String, String> params) {
        if (params.size() == 0) {
            // Query all films - don't throw NOT_FOUND exception
            List<Film> entities = filmService.findAll();
            return entities;

        } else if (params.size() > 1) {
            // Too many parameters
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Too many parameters");

        } else if (params.containsKey("title")) {
            // Query by title
            String value = params.get("title").trim();
            logger.debug("Finding film param title: {}", value);
            List<Film> entities = filmService.findByTitle(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;

        } else if (params.containsKey("year")) {
            // Query by release year
            int value;
            try {
                value = Integer.parseInt(params.get("year"));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid film parameter");
            }
            logger.debug("Finding film param year: {}", value);
            List<Film> entities = filmService.findByReleaseYear(value);
            if (entities.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return entities;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid query parameter");
    }
}
