package com.example.movies_sandbox.service;


import com.example.movies_sandbox.entity.Genre;
import com.example.movies_sandbox.entity.dto.GenreDto;
import com.example.movies_sandbox.entity.mapper.GenreCustomMapper;
import com.example.movies_sandbox.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository repository;
    private final GenreCustomMapper mapper;

    public GenreDto create(GenreDto genreDto) {
        if(genreDto == null) {
            throw new IllegalArgumentException("Genre should not be null");
        }

        Genre entity = mapper.toEntity(genreDto);
        repository.save(entity);
        return genreDto;
    }

    public List<GenreDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    public GenreDto getGenreById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Genre with id " + id + " was not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public GenreDto update(Long id, GenreDto genreDto) {
        if (genreDto == null) {
            throw new IllegalArgumentException("Genre should not be null");
        }

        Optional<Genre> possibleGenre = repository.findById(id);
        if(possibleGenre.isEmpty()) {
            throw new RuntimeException("Genre with id " + id + " was not found");
        }

        Genre newEntity = mapper.toEntity(genreDto);
        newEntity.setId(id);
        repository.save(newEntity);
        return genreDto;
    }
}
