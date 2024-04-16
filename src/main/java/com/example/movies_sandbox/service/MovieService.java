package com.example.movies_sandbox.service;

import com.example.movies_sandbox.entity.Movie;
import com.example.movies_sandbox.entity.dto.MovieDto;
import com.example.movies_sandbox.entity.mapper.MovieMapper;
import com.example.movies_sandbox.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends BaseService<Movie, MovieDto> {

    public MovieService(BaseRepository<Movie> baseRepository, MovieMapper mapper) {
        super(baseRepository, mapper);
    }

}
