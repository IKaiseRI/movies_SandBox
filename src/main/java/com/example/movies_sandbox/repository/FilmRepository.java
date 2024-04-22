package com.example.movies_sandbox.repository;

import com.example.movies_sandbox.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query("SELECT f from Film f order by f.filmId ASC LIMIT 10")
    List<Film> findFirst10();
}

