package com.example.movies_sandbox.entity.mapper;

public interface MainMapper<ENTITY, DTO> {

    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);
}
