package com.example.movies_sandbox.repository;

import com.example.movies_sandbox.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String string);

    Set<Category> findAllByName(Set<String> names);
}
