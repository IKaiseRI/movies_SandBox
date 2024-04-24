package com.example.movies_sandbox.entity.mappers;

import com.example.movies_sandbox.entity.Actor;
import com.example.movies_sandbox.entity.Category;
import com.example.movies_sandbox.entity.Country;
import com.example.movies_sandbox.entity.Film;
import com.example.movies_sandbox.entity.Language;
import com.example.movies_sandbox.entity.SpecialFeature;
import com.example.movies_sandbox.entity.dto.FilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    @Mapping(target = "originalMovieLanguage", source = "originalMovieLanguage.name")
    @Mapping(target = "languages", source = "languages", qualifiedByName = "dtoMapTranslatedLanguages")
    @Mapping(target = "categories", source = "categories", qualifiedByName = "dtoMapFilmCategories")
    @Mapping(target = "countries", source = "countries", qualifiedByName = "dtoMapCountries")
    @Mapping(target = "specialFeatures", source = "specialFeatures", qualifiedByName = "dtoMapSpecialFeatures")
    @Mapping(target = "actors", source = "actors", qualifiedByName = "dtoMapActors")
    FilmDto toDto(Film film);

    @Named("dtoMapTranslatedLanguages")
    default Set<String> dtoMapTranslatedLanguages(Set<Language> languages) {
        return languages.stream()
                .map(Language::getName)
                .collect(Collectors.toSet());
    }

    @Named("dtoMapFilmCategories")
    default Set<String> dtoMapFilmCategories(Set<Category> categories) {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toSet());
    }

    @Named("dtoMapCountries")
    default Set<String> dtoMapCountries(Set<Country> countries) {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toSet());
    }

    @Named("dtoMapSpecialFeatures")
    default Set<String> dtoMapSpecialFeatures(Set<SpecialFeature> specialFeatures) {
        return specialFeatures.stream()
                .map(SpecialFeature::getName)
                .collect(Collectors.toSet());
    }

    @Named("dtoMapActors")
    default Set<String> dtoMapActors(Set<Actor> actors) {
        return actors.stream()
                .map(actor -> actor.getFirstName() + " " + actor.getLastName())
                .collect(Collectors.toSet());
    }
}
