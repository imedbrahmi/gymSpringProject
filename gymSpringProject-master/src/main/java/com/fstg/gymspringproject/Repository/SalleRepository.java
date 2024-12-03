package com.fstg.gymspringproject.Repository;

import com.fstg.gymspringproject.Entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {

    List<Salle> findByNameContaining(String name);

    List<Salle> findByCapacityGreaterThanEqual(int capacity);

    List<Salle> findByClubId(Long clubId);
}
