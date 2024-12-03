package com.fstg.gymspringproject.Services;

import com.fstg.gymspringproject.Entity.Salle;
import com.fstg.gymspringproject.Repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SalleService {

    private final SalleRepository salleRepository;

    // Injection de dépendance via le constructeur
    @Autowired
    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    // Méthode pour récupérer une salle par son identifiant
    public Optional<Salle> getSalleById(Long id) {
        return salleRepository.findById(id);
    }

    // Méthode pour récupérer toutes les salles
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    // Méthode pour ajouter ou mettre à jour une salle
    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    // Méthode pour supprimer une salle
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }

    // Méthode pour récupérer les salles par nom
    public List<Salle> getSallesByNom(String nom) {
        return salleRepository.findByNameContaining(nom);
    }
}
