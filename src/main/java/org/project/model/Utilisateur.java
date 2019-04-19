package org.project.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class Utilisateur {
    private String nom;
    // L'adresse mail est unique donc je vais l'utiliser pour la suppression par exemple
    @Id
    private String email;
}
