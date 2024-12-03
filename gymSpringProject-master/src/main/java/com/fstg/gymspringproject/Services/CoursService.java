package com.fstg.gymspringproject.Services;



import com.fstg.gymspringproject.Entity.Cours;
import com.fstg.gymspringproject.Entity.Coach;
import com.fstg.gymspringproject.Repository.CoursRepository;
import com.fstg.gymspringproject.Repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {

    private final CoursRepository coursRepository;
    private final CoachRepository coachRepository;

    public CoursService(CoursRepository coursRepository, CoachRepository coachRepository) {
        this.coursRepository = coursRepository;
        this.coachRepository = coachRepository;
    }

    // Créer un nouveau cours
    public Cours createCours(Cours cours) {
        return coursRepository.save(cours);
    }

    // Trouver un cours par ID
    public Cours findCoursById(Long id) {
        return coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé avec l'ID: " + id));
    }

    // Trouver tous les cours
    public List<Cours> findAllCours() {
        return coursRepository.findAll();
    }



    // Mettre à jour un cours existant
    public Cours updateCours(Long id, Cours updatedCours) {
        Cours cours = findCoursById(id);
        cours.setNom_cours(updatedCours.getNom_cours());
        cours.setDuree(updatedCours.getDuree());
        cours.setType(updatedCours.getType());
        cours.setHeureDebut(updatedCours.getHeureDebut());
        cours.setHeureFin(updatedCours.getHeureFin());
        cours.setSalle(updatedCours.getSalle());
        cours.setCoachs(updatedCours.getCoachs());
        return coursRepository.save(cours);
    }

    // Supprimer un cours
    public void deleteCours(Long id) {
        Cours cours = findCoursById(id);
        coursRepository.delete(cours);
    }

    // Ajouter un coach à un cours
    public Cours addCoachToCours(Long coursId, Long coachId) {
        Cours cours = findCoursById(coursId);
        Coach coach = coachRepository.findById(coachId)
                .orElseThrow(() -> new RuntimeException("Coach non trouvé avec l'ID: " + coachId));

        cours.getCoachs().add(coach); // Ajoute le coach à la liste
        return coursRepository.save(cours);
    }
}
