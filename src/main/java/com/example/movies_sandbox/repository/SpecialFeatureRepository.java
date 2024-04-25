package com.example.movies_sandbox.repository;

import com.example.movies_sandbox.entity.SpecialFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SpecialFeatureRepository extends JpaRepository<SpecialFeature, Long> {

    Optional<SpecialFeature> findByName(String string);

    Set<SpecialFeature> findAllByName(Set<String> names);
}