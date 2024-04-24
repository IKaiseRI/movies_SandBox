package com.example.movies_sandbox.entity.mappers;

import com.example.movies_sandbox.entity.Language;
import com.example.movies_sandbox.entity.dto.LanguageDto;
import com.example.movies_sandbox.utils.UtilsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UtilsMapper.class})
public interface LanguageMapper {

    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    @Mapping(target = "films", source = "films", qualifiedByName = "dtoMapFilms")
    LanguageDto toDto(Language language);
}
