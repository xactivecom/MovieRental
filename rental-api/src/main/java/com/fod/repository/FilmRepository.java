package com.fod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fod.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    
    @Query("SELECT f FROM Film f WHERE f.title = :title")
    List<Film> findByTitle(@Param("title") String title);

    @Query("SELECT f FROM Film f WHERE f.title LIKE :title")
    List<Film> findByTitleLike(@Param("title") String title);

    @Query("SELECT f FROM Film f WHERE f.release_year = :year")
    List<Film> findByReleaseYear(@Param("year") Integer year);
}
