package com.example.movies_sandbox.service;

import com.example.movies_sandbox.entity.Film;
import com.example.movies_sandbox.entity.dto.FilmDto;
import com.example.movies_sandbox.entity.mappers.FilmCreateEditMapper;
import com.example.movies_sandbox.entity.mappers.FilmReadMapper;
import com.example.movies_sandbox.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;
    private final FilmCreateEditMapper filmCreateEditMapper;

    public List<FilmDto> findFirst10() {
        return filmRepository.findFirst10().stream()
                .map(FilmReadMapper.INSTANCE::toDto)
                .toList();
    }

    public FilmDto findById(Long id) {
        return filmRepository.findById(id)
                .map(FilmReadMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NoSuchElementException("No film found with id: " + id));
    }

    public FilmDto create(FilmDto filmDto) {
        return FilmReadMapper.INSTANCE.toDto(filmRepository.save(filmCreateEditMapper.toEntity(filmDto)));
    }

    public FilmDto update(Long id, FilmDto filmDto) {
        Film old = filmRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No film found with id: " + id));

        Film newFilm = filmCreateEditMapper.toEntity(filmDto);
        newFilm.setId(old.getId());

        return FilmReadMapper.INSTANCE.toDto(filmRepository.save(newFilm));
    }

    public void deleteById(Long id) {
        filmRepository.deleteById(id);
    }
}
