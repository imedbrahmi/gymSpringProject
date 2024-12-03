package com.fstg.gymspringproject.Repository;


import com.fstg.gymspringproject.Entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

    @Repository
    public interface ClubRepository extends JpaRepository<Club, Long> {
        List<Club> findByNameContaining(String keyword);
        List<Club> findByLocation(String location);
    }

