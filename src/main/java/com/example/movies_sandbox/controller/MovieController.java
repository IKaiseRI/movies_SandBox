package com.example.movies_sandbox.controller;


import com.example.movies_sandbox.entity.dto.MovieDto;
import com.example.movies_sandbox.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    @PostMapping
    public MovieDto createMovie(@RequestBody MovieDto movieDto) {
        return service.create(movieDto);
    }

    @GetMapping("/{id}")
    public MovieDto getMovieById(@PathVariable Long id) {
        return service.getMovieById(id);
    }

    @GetMapping
    public List<MovieDto> getAllMovies() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public void updateMovie(
            @PathVariable Long id,
            @RequestBody MovieDto movieDto
    ) {
        service.update(id, movieDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        service.deleteById(id);
    }
}
