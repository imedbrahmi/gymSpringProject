package com.fstg.gymspringproject.Repository;


    import com.fstg.gymspringproject.Entity.Cours;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.time.LocalTime;
    import java.util.List;

    @Repository
    public interface CoursRepository extends JpaRepository<Cours, Long> {

        List<Cours> findByCoachId(Long coachId);

        List<Cours> findByClubId(Long clubId);

        List<Cours> findByNameContaining(String name);

        // Recherche de cours en fonction de l'heure de début
        List<Cours> findByHeureDebutBefore(LocalTime heure);

        // Recherche de cours en fonction de l'heure de fin
        List<Cours> findByHeureFinAfter(LocalTime heure);    }


