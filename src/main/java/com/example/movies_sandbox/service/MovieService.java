package com.example.movies_sandbox.service;

import com.example.movies_sandbox.entity.Movie;
import com.example.movies_sandbox.entity.dto.MovieDto;
import com.example.movies_sandbox.entity.mapper.MovieCustomMapper;
import com.example.movies_sandbox.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final MovieCustomMapper mapper;

    public MovieDto create(MovieDto movieDto) {
        if (movieDto == null) {
            throw new IllegalArgumentException("Movie should not be null");
        }

        Movie entity = mapper.toEntity(movieDto);
        repository.save(entity);
        return movieDto;
    }

    public List<MovieDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public MovieDto getMovieById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Movie with id " + id + " was not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public MovieDto update(Long id, MovieDto movieDto) {
        if (movieDto == null) {
            throw new IllegalArgumentException("Movie should not be null");
        }

        Optional<Movie> possibleMovie = repository.findById(id);
        if (possibleMovie.isEmpty()) {
            throw new RuntimeException("Movie with id " + id + " was not found ");
        }

        Movie newEntity = mapper.toEntity(movieDto);
        newEntity.setId(id);
        repository.save(newEntity);
        return movieDto;
    }
}
