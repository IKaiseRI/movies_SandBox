package com.example.movies_sandbox.service;

import com.example.movies_sandbox.entity.mapper.MainMapper;
import com.example.movies_sandbox.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseService<ENTITY, DTO> {

    private final BaseRepository<ENTITY> repository;
    private final MainMapper<ENTITY, DTO> mapper;

    public List<DTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public DTO create(DTO dto) {
        ENTITY entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public DTO findById(Long id) {
        ENTITY entity = repository.findById(id)
                .orElseThrow(() -> new NullPointerException("Entity not found"));

        return mapper.toDto(entity);
    }

    @SneakyThrows
    public void update(Long id, DTO entity) {
        ENTITY existingEntity = repository.findById(id)
                .orElseThrow(() -> new NullPointerException("Entity not found"));

        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.get(entity) != null) {
                field.set(existingEntity, field.get(entity));
            }
            field.setAccessible(false);
        }

        repository.save(existingEntity);
    }
}
