package com.example.movies_sandbox.entity.dto;

import java.util.Set;

public record GenreDto(
        String name,
        Set<String> movies
) {
}
