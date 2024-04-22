package com.example.movies_sandbox.utils;

import com.example.movies_sandbox.entity.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return (rating != null) ? Rating.valueOf(rating) : null;
    }

    @Override
    public Rating convertToEntityAttribute(String s) {
        return (s != null) ? Rating.valueOfLabel(s) : null;
    }
}
