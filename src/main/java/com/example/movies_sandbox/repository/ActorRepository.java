package com.example.movies_sandbox.repository;

import com.example.movies_sandbox.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    Optional<Actor> findByName(String string);

    @Query("SELECT a FROM Actor a WHERE CONCAT(a.firstName, ' ' , a.lastName) IN :actors")
    Set<Actor> findAllByFullName(@Param("actors") Set<String> actors);
}