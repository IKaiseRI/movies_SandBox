package com.example.movies_sandbox.controller;


import com.example.movies_sandbox.entity.Film;
import com.example.movies_sandbox.entity.dto.FilmDto;
import com.example.movies_sandbox.entity.mappers.FilmReadMapper;
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
        return filmRepository.findFirst10();
    }

    @GetMapping("/first")
    public FilmDto findFirst() {
        return FilmReadMapper.INSTANCE.toDto(filmRepository.findFirst());
    }
}
