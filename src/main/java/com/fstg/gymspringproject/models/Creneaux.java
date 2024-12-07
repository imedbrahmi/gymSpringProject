package com.fstg.gymspringproject.models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Creneaux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime debut_cours;
    private LocalDateTime fin_cours;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours; // Cours associé à ce créneau

    // Getters et Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDebut_cours() {
        return debut_cours;
    }

    public void setDebut_cours(LocalDateTime debut_cours) {
        this.debut_cours = debut_cours;
    }

    public LocalDateTime getFin_cours() {
        return fin_cours;
    }

    public void setFin_cours(LocalDateTime fin_cours) {
        this.fin_cours = fin_cours;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
