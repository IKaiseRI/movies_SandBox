package com.example.movies_sandbox.entity.mappers;


import com.example.movies_sandbox.entity.Category;
import com.example.movies_sandbox.entity.dto.CategoryDto;
import com.example.movies_sandbox.utils.UtilsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UtilsMapper.class})
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "films", source = "films", qualifiedByName = "dtoMapFilms")
    CategoryDto toDto(Category country);
}
