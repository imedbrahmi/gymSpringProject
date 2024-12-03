package com.fstg.gymspringproject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_club;

    private String nom_club;
    private String adresse;
    private String numero_tel;

    private String heure_ouverture; // Format : HH:mm
    private String heure_fermeture; // Format : HH:mm

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Salle> salles; // Liste des salles dans ce club

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Cours> cours; // Liste des cours associés au club

    // Getters et Setters


    public Long getId_club() {
        return id_club;
    }

    public void setId_club(Long id_club) {
        this.id_club = id_club;
    }

    public String getNom_club() {
        return nom_club;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumero_tel() {
        return numero_tel;
    }

    public void setNumero_tel(String numero_tel) {
        this.numero_tel = numero_tel;
    }

    public String getHeure_ouverture() {
        return heure_ouverture;
    }

    public void setHeure_ouverture(String heure_ouverture) {
        this.heure_ouverture = heure_ouverture;
    }

    public String getHeure_fermeture() {
        return heure_fermeture;
    }

    public void setHeure_fermeture(String heure_fermeture) {
        this.heure_fermeture = heure_fermeture;
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}
