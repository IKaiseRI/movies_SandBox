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

    private String title;
    private String description;
    private Year releaseYear;
    private String originalMovieLanguage;
    private Set<String> languages;
    private Set<String> categories;
    private Rating ageRating;
    private Set<String> countries;
    private Set<String> specialFeatures;

    public Set<String> getLanguages() {
        return languages;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public Set<String> getCountries() {
        return countries;
    }

    public Set<String> getSpecialFeatures() {
        return specialFeatures;
    }

    public Set<String> getActors() {
        return actors;
    }

    private Set<String> actors;
}
