package com.fstg.gymspringproject.repository;

import com.fstg.gymspringproject.models.Coach;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CoachRepository extends CrudRepository<Coach, Long> {
    List<Coach> findAll();
    Optional<Coach> findById(long id);
    Optional<Coach> findByNomAndPrenom(String nom, String prenom);
}
