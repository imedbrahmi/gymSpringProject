package com.fstg.gymspringproject.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cours;

    private String nom_cours;
    private int duree; // Durée en minutes
    private String type; // Type de cours (Yoga, Zumba, etc.)
    private LocalTime heureDebut; // Ajout de l'heure de début
    private LocalTime heureFin;
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle; // Salle où se déroule le cours

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club; // Club auquel appartient ce cours

    @ManyToMany
    @JoinTable(
            name = "cours_coach",
            joinColumns = @JoinColumn(name = "cours_id"),
            inverseJoinColumns = @JoinColumn(name = "coach_id")
    )
    private List<Coach> coachs;



 }