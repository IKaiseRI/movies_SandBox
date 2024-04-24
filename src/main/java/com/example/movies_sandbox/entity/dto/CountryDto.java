package com.example.movies_sandbox.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class CountryDto {
    private String name;
    private Set<String> films;
}
