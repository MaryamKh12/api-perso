package org.project.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@Data
public class Utilisateur {
    @Column(name="nom")
    private String nom;
    // L'adresse mail est unique donc je vais l'utiliser pour la suppression par exemple
    @Id
    @Column(name="email")
    private String email;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
}
