package com.fstg.gymspringproject.repository;

import com.fstg.gymspringproject.models.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Integer> {
    List<Cours> findByNomcours(String nomcours);
    List<Cours> findByClubId(Long clubId);
    List<Cours> findByType(String type);
    List<Cours> findBySalle_Id(Long salleId);
    List<Cours> findByClub_Id(Long clubId);

}
