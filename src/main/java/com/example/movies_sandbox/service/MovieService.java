package com.example.movies_sandbox.service;

import com.example.movies_sandbox.entity.Movie;
import com.example.movies_sandbox.entity.mapper.MovieMapper;
import com.example.movies_sandbox.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper mapper;

    public MovieService(MovieRepository movieRepository, MovieMapper mapper) {
        this.movieRepository = movieRepository;
        this.mapper = mapper;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
