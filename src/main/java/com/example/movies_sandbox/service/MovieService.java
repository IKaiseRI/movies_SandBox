package com.example.movies_sandbox.service;

import com.example.movies_sandbox.entity.Genre;
import com.example.movies_sandbox.entity.Movie;
import com.example.movies_sandbox.entity.dto.MovieDto;
import com.example.movies_sandbox.entity.mapper.MovieCustomMapper;
import com.example.movies_sandbox.repository.GenreRepository;
import com.example.movies_sandbox.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final MovieCustomMapper mapper;

    public MovieDto create(MovieDto movieDto) {
        if (movieDto == null) {
            throw new IllegalArgumentException("Movie should not be null");
        }

        Movie entity = checkAndCreateNewMovieGenres(movieDto);

        movieRepository.save(entity);

        return movieDto;
    }

    public List<MovieDto> findAll() {
        return movieRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public MovieDto getMovieById(Long id) {
        return movieRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Movie with id " + id + " was not found"));
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    public MovieDto update(Long id, MovieDto movieDto) {
        if (movieDto == null) {
            throw new IllegalArgumentException("Movie should not be null");
        }

        Optional<Movie> possibleMovie = movieRepository.findById(id);
        if (possibleMovie.isEmpty()) {
            throw new RuntimeException("Movie with id " + id + " was not found ");
        }

        Movie newEntity = checkAndCreateNewMovieGenres(movieDto);
        newEntity.setId(id);
        movieRepository.save(newEntity);
        return movieDto;
    }


    private Movie checkAndCreateNewMovieGenres(MovieDto movieDto) {
        Movie entity = mapper.toEntity(movieDto);

        List<Genre> allGenresInDataBase = genreRepository.findAll();

        Set<Genre> existingGenresInDataBase = allGenresInDataBase.stream()
                .filter(genre -> movieDto.getGenres().contains(genre.getName()))
                .collect(Collectors.toSet());

        Set<Genre> newGenresNotInDataBase = entity.getGenres().stream()
                .filter(entityGenre -> allGenresInDataBase.stream()
                        .noneMatch(genre -> genre.getName().equals(entityGenre.getName())))
                .collect(Collectors.toSet());

        genreRepository.saveAll(newGenresNotInDataBase);

        Set<Genre> allGenres = new HashSet<>(existingGenresInDataBase);
        allGenres.addAll(newGenresNotInDataBase);
        entity.setGenres(allGenres);
        return entity;
    }
}
