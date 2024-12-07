package com.fstg.gymspringproject.repository;

import com.fstg.gymspringproject.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Integer> {
    List<Club> findByNomclub(String nomclub);

}
