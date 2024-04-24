package com.example.movies_sandbox.entity.mappers;

import com.example.movies_sandbox.entity.Actor;
import com.example.movies_sandbox.entity.dto.ActorDto;
import com.example.movies_sandbox.utils.UtilsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UtilsMapper.class})
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    @Mapping(target = "films", source = "films", qualifiedByName = "dtoMapFilms")
    ActorDto toDto(Actor actor);
}
