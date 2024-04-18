package com.example.movies_sandbox.entity.mapper;

import com.example.movies_sandbox.entity.dto.GenreDto;
import com.example.movies_sandbox.entity.Genre;
import com.example.movies_sandbox.entity.Movie;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@org.mapstruct.Mapper
public interface GenreMapper extends Mapper<Genre, GenreDto> {

    @Mapping(target = "movies", source = "movies", qualifiedByName = "mapFromMoviesToStrings")
    GenreDto toDto(Genre genre);

    @Mapping(target = "movies", source = "movies", qualifiedByName = "mapFromStringsToMovies")
    Genre toEntity(GenreDto dto);

    @Named("mapFromMoviesToStrings")
    default Set<String> mapFromMoviesToStrings(Set<Movie> movies) {
        return movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toSet());
    }

    @Named("mapFromStringsToMovies")
    default Set<Movie> mapFromStringsToMovies(Set<String> movieTitles) {
        return movieTitles.stream()
                .map(title -> {
                    Movie movie = new Movie();
                    movie.setTitle(title);
                    return movie;
                })
                .collect(Collectors.toSet());
    }
}
