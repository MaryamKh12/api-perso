package org.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Volet")
@Data
public class Volet {

    // Je rajoute un id ici pour pouvoir identifier un volet
    @Id
    @Column(name="numero")
    private Integer numero;
    @Column(name="libelle")
    private String libelle;
    @Column(name="piece_rattachement")
    private String pieceRattachement;
    @Column(name="pourcentage_fermeture")
    private Integer pourcentageFermeture;
    @Column(name="etat")
    private Integer etat;
    // Un volet doit être nécessairement attaché à un user
    @ManyToOne
    @JoinColumn(name="email")
    private Utilisateur utilisateur;

    public Volet(Integer numero, String libelle, String pieceRattachement, Integer pourcentageFermeture, Integer etat, Utilisateur utilisateur) {
        this.numero = numero;
        this.libelle = libelle;
        this.pieceRattachement = pieceRattachement;
        this.pourcentageFermeture = pourcentageFermeture;
        this.etat = etat;
        this.utilisateur = utilisateur;
    }
}
