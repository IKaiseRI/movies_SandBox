package com.example.movies_sandbox.service;

import com.example.movies_sandbox.entity.dto.FilmDto;
import com.example.movies_sandbox.entity.mappers.FilmMapper;
import com.example.movies_sandbox.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    public List<FilmDto> findFirst10() {
        return filmRepository.findFirst10().stream()
                .map(FilmMapper.INSTANCE::toDto)
                .toList();
    }

    public FilmDto findById(Long id) {
        return filmRepository.findById(id)
                .map(FilmMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NoSuchElementException("No film found with id: " + id));
    }

    public void deleteById(Long id) {
        filmRepository.deleteById(id);
    }
}
