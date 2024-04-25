package com.example.movies_sandbox.entity.dto;

import com.example.movies_sandbox.entity.enums.Rating;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;
import java.util.Set;

@Getter
@Setter
@Builder
public class FilmDto {

    private Long id;
    private String title;
    private String description;
    private Year releaseYear;
    private String originalMovieLanguage;
    private Set<String> languages;
    private Set<String> categories;
    private Rating ageRating;
    private Set<String> countries;
    private Set<String> specialFeatures;
    private Set<String> actors;
}
