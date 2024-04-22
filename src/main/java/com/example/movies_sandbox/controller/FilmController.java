package com.example.movies_sandbox.controller;


import com.example.movies_sandbox.entity.Film;
import com.example.movies_sandbox.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmRepository filmRepository;

    @GetMapping
    public List<Film> findAll() {
        filmRepository.findAll().forEach(System.out::println);
        return filmRepository.findAll();
    }
}
