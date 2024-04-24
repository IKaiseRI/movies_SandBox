package com.example.movies_sandbox.entity.mappers;

import com.example.movies_sandbox.entity.SpecialFeature;
import com.example.movies_sandbox.entity.dto.SpecialFeatureDto;
import com.example.movies_sandbox.utils.UtilsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UtilsMapper.class})
public interface SpecialFeatureMapper {

    SpecialFeatureMapper INSTANCE = Mappers.getMapper(SpecialFeatureMapper.class);

    @Mapping(target = "films", source = "films", qualifiedByName = "dtoMapFilms")
    SpecialFeatureDto toDto(SpecialFeature country);
}
