package com.example.movies_sandbox.dto;

import java.util.Date;
import java.util.Set;

public record MovieDto(
        String title,
        String director,
        Date releaseDate,
        Set<String> genres
) {
}
