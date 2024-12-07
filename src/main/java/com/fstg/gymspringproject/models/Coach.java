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

public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private float prix_cours;

    @ManyToMany(mappedBy = "coachs", cascade = CascadeType.ALL)
    private List<Cours> cours;

    // Getters et Setters
}
