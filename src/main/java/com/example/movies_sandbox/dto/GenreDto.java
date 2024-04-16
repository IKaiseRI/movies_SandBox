package com.example.movies_sandbox.dto;

import java.util.Set;

public record GenreDto(
        String name,
        Set<String> movies
) {
}
