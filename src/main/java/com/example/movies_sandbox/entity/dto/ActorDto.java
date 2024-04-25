package com.example.movies_sandbox.entity.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Builder
public class ActorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<String> films;
}
