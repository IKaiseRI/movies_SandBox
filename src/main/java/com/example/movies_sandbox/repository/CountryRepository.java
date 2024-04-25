package com.example.movies_sandbox.repository;

import com.example.movies_sandbox.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByName(String string);

    Set<Country> findAllByName(Set<String> names);
}
