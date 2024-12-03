package com.fstg.gymspringproject.Repository;

import com.fstg.gymspringproject.Entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

    List<Coach> findBySpecialtyContaining(String specialty);

    List<Coach> findByClubId(Long clubId);

    List<Coach> findByNameContaining(String name);
}
