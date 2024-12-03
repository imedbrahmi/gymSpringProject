package com.fstg.gymspringproject.Services;


import com.fstg.gymspringproject.Entity.Coach;
import com.fstg.gymspringproject.Repository.CoachRepository;
import com.fstg.gymspringproject.Entity.Cours;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    // Créer un nouveau coach
    public Coach createCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    // Trouver un coach par ID
    public Coach findCoachById(Long id) {
        return coachRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coach non trouvé avec l'ID: " + id));
    }

    // Trouver tous les coachs
    public List<Coach> findAllCoachs() {
        return coachRepository.findAll();
    }

    // Trouver un coach par nom
    public List<Coach> findCoachByName(String name) {
        return coachRepository.findByNameContaining(name); // Recherche par nom
    }

    // Mettre à jour un coach
    public Coach updateCoach(Long id, Coach updatedCoach) {
        Coach coach = findCoachById(id);
        coach.setNom(updatedCoach.getNom());
        coach.setPrenom(updatedCoach.getPrenom());
        coach.setPrix_cours(updatedCoach.getPrix_cours());
        return coachRepository.save(coach);
    }

    // Supprimer un coach
    public void deleteCoach(Long id) {
        Coach coach = findCoachById(id);
        coachRepository.delete(coach);
    }

    // Ajouter un coach à un cours
    public void addCoachToCours(Long coachId, Long coursId) {
        Coach coach = findCoachById(coachId);

      }
}
