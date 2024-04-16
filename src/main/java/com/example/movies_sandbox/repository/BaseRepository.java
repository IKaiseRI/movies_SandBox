package com.example.movies_sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<ENTITY> extends JpaRepository<ENTITY, Long> {
}
