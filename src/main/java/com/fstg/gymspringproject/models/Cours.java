package com.fstg.gymspringproject.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cours;

    private String nomcours;
    private int duree; // Durée en minutes
    private String type; // Type de cours (Yoga, Zumba, etc.)

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

    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    private List<Creneaux> creneaux; // Les créneaux associés au cours

    // Getters et Setters

    public Long getId_cours() {
        return id_cours;
    }

    public void setId_cours(Long id_cours) {
        this.id_cours = id_cours;
    }

    public String getNomcours() {
        return nomcours;
    }

    public void setNomcours(String nomcours) {
        this.nomcours = nomcours;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<Coach> getCoachs() {
        return coachs;
    }

    public void setCoachs(List<Coach> coachs) {
        this.coachs = coachs;
    }

    public List<Creneaux> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(List<Creneaux> creneaux) {
        this.creneaux = creneaux;
    }
}