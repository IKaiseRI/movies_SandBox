package com.example.movies_sandbox.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Builder
public class CategoryDto {

    private Long id;
    private String name;
    private Set<String> films;
}
