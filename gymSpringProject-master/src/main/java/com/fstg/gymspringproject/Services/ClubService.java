package com.fstg.gymspringproject.Services;


import com.fstg.gymspringproject.Entity.Club;
import com.fstg.gymspringproject.Repository.ClubRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    // Créer un nouveau club
    @Transactional
    public Club createClub(Club club) {
        return clubRepository.save(club);
    }

    // Mettre à jour un club existant
    @Transactional
    public Club updateClub(Long clubId, Club clubDetails) {
        Optional<Club> existingClub = clubRepository.findById(clubId);
        if (existingClub.isPresent()) {
            Club club = existingClub.get();
            club.setNom_club(clubDetails.getNom_club());
            club.setAdresse(clubDetails.getAdresse());
            club.setNumero_tel(clubDetails.getNumero_tel());
            club.setHeure_ouverture(clubDetails.getHeure_ouverture());
            club.setHeure_fermeture(clubDetails.getHeure_fermeture());
            // Mise à jour des autres attributs
            return clubRepository.save(club);
        }
        throw new RuntimeException("Club not found with id: " + clubId);
    }

    // Récupérer tous les clubs
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    // Récupérer un club par son ID
    public Club getClubById(Long clubId) {
        return clubRepository.findById(clubId)
                .orElseThrow(() -> new RuntimeException("Club not found with id: " + clubId));
    }

    // Supprimer un club
    @Transactional
    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    // Recherche de clubs par nom
    public List<Club> getClubsByName(String name) {
        return clubRepository.findByNameContaining(name);
    }
}
