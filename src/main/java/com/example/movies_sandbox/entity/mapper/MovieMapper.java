package com.example.movies_sandbox.entity.mapper;

import com.example.movies_sandbox.entity.dto.MovieDto;
import com.example.movies_sandbox.entity.Genre;
import com.example.movies_sandbox.entity.Movie;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@org.mapstruct.Mapper
public interface MovieMapper extends Mapper<Movie, MovieDto> {

    @Mapping(target = "genres", source = "genres", qualifiedByName = "mapFromGenresToStrings")
    MovieDto toDto(Movie entity);

    @Mapping(target = "genres", source = "genres", qualifiedByName = "mapFromStringsToGenres")
    Movie toEntity(MovieDto dto);

    @Named("mapFromGenresToStrings")
    default Set<String> mapFromGenresToStrings(Set<Genre> genres) {
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toSet());
    }

    @Named("mapFromStringsToGenres")
    default Set<Genre> mapFromStringsToGenres(Set<String> genres) {
        return genres.stream()
                .map(name -> {
                    Genre genre = new Genre();
                    genre.setName(name);
                    return genre;
                })
                .collect(Collectors.toSet());
    }
}

