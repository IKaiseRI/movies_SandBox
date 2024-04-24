package com.example.movies_sandbox.entity;

import com.example.movies_sandbox.entity.enums.Rating;
import com.example.movies_sandbox.utils.RatingConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"title", "description"})
@ToString(exclude = "countries")
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Year releaseYear;

    @OneToOne
    @JoinColumn(name = "original_language_id")
    private Language originalMovieLanguage;

    @ManyToMany
    @JoinTable(
            name = "film_language",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> translatedLanguages = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> filmCategories = new HashSet<>();

    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;

    @Convert(converter = RatingConverter.class)
    private Rating ageRating;

    @Schema(hidden = true)
    @ManyToMany
    @JoinTable(
            name = "film_country",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    @Builder.Default
    private Set<Country> countries = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "film_special_feature",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "special_feature_id")
    )
    private Set<SpecialFeature> specialFeatures = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors = new ArrayList<>();

}
