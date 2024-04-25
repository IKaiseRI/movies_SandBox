package com.example.movies_sandbox.entity.mappers;

import com.example.movies_sandbox.entity.Film;
import com.example.movies_sandbox.entity.dto.FilmDto;
import com.example.movies_sandbox.repository.ActorRepository;
import com.example.movies_sandbox.repository.CategoryRepository;
import com.example.movies_sandbox.repository.CountryRepository;
import com.example.movies_sandbox.repository.LanguageRepository;
import com.example.movies_sandbox.repository.SpecialFeatureRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
@RequiredArgsConstructor
public abstract class FilmCreateEditMapper {

    protected LanguageRepository languageRepository;
    protected ActorRepository actorRepository;
    protected CategoryRepository categoryRepository;
    protected CountryRepository countryRepository;
    protected SpecialFeatureRepository specialFeatureRepository;

    FilmCreateEditMapper INSTANCE = Mappers.getMapper(FilmCreateEditMapper.class);

    @Mapping(target = "originalMovieLanguage.name", source = "originalMovieLanguage")
    @Mapping(target = "languages", expression = "java(languageRepository.findAllByName(filmDto.getLanguages()))")
    @Mapping(target = "categories", expression = "java(categoryRepository.findAllByName(filmDto.getCategories()))")
    @Mapping(target = "countries", expression = "java(countryRepository.findAllByName(filmDto.getCountries()))")
    @Mapping(target = "specialFeatures", expression = "java(specialFeatureRepository.findAllByName(filmDto.getSpecialFeatures()))")
    @Mapping(target = "actors", expression = "java(actorRepository.findAllByFullName(filmDto.getActors()))")
    public abstract Film toEntity(FilmDto filmDto);

//    @Named("entityMapTranslatedLanguages")
//    default Set<Language> entityMapTranslatedLanguages(Set<String> languages, LanguageRepository repository) {
//        return new HashSet<>(repository.findAllByName(languages));
//    }
//
//    @Named("entityMapFilmCategories")
//    default Set<Category> entityMapFilmCategories(Set<String> categories, CategoryRepository repository) {
//        return new HashSet<>(repository.findAllByName(categories));
//    }
//
//    @Named("entityMapCountries")
//    default Set<Country> entityMapCountries(Set<String> countries, CountryRepository repository) {
//        return new HashSet<>(repository.findAllByName(countries));
//    }
//    @Named("entityMapSpecialFeatures")
//    default Set<SpecialFeature> entityMapSpecialFeatures(Set<String> specialFeatures, SpecialFeatureRepository repository){
//        return new HashSet<>(repository.findAllByName(specialFeatures));
//    }
//    @Named("entityMapActors")
//    default Set<Actor> entityMapActors(Set<String> actors, ActorRepository repository) {
//        return new HashSet<>(repository.findAllByFullName(actors));
//    }
}
