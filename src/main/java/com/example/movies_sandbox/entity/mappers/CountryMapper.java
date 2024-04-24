package com.example.movies_sandbox.entity.mappers;

import com.example.movies_sandbox.entity.Country;
import com.example.movies_sandbox.entity.dto.CountryDto;
import com.example.movies_sandbox.utils.UtilsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UtilsMapper.class})
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "films", source = "films", qualifiedByName = "dtoMapFilms")
    CountryDto toDto(Country country);
}
