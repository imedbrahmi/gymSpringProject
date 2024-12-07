package com.fstg.gymspringproject.repository;

import com.fstg.gymspringproject.models.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalleRepository extends JpaRepository<Salle, Integer> {
    List<Salle> findByName(String SalleName);
}
