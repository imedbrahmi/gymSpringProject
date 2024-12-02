package com.fstg.gymspringproject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_salle;

    private String nom_salle;
    private int capacite;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club; // Salle liée à un club

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
    private List<Cours> cours;

    // Getters et Setters


    public Long getId_salle() {
        return id_salle;
    }

    public void setId_salle(Long id_salle) {
        this.id_salle = id_salle;
    }

    public String getNom_salle() {
        return nom_salle;
    }

    public void setNom_salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}