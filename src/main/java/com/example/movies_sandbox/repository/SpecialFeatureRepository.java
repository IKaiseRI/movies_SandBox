package com.example.movies_sandbox.repository;

import com.example.movies_sandbox.entity.SpecialFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialFeatureRepository extends JpaRepository<SpecialFeature, Long> {
}
