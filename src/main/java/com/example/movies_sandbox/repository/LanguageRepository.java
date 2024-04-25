package com.example.movies_sandbox.repository;

import com.example.movies_sandbox.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Optional<Language> findByName(String string);

    Set<Language> findAllByName(Set<String> names);
}
