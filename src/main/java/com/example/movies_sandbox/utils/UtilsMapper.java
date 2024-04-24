package com.example.movies_sandbox.utils;

import com.example.movies_sandbox.entity.Film;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

public class UtilsMapper {

    @Named("dtoMapFilms")
    public static Set<String> dtoMapFilms(Set<Film> films) {
        return films.stream()
                .map(Film::getTitle)
                .collect(Collectors.toSet());
    }
}
