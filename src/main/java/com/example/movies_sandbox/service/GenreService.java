package com.example.movies_sandbox.service;


import com.example.movies_sandbox.entity.Genre;
import com.example.movies_sandbox.entity.dto.GenreDto;
import com.example.movies_sandbox.entity.mapper.GenreMapper;
import com.example.movies_sandbox.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends BaseService<Genre, GenreDto> {

    public GenreService(BaseRepository<Genre> repository, GenreMapper genreMapper) {
        super(repository, genreMapper);
    }
}
