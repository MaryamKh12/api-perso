package org.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Volet")
@Data
@AllArgsConstructor
public class Volet {

    // Je rajoute un id ici pour pouvoir identifier un volet
    @Id
    private String numero;
    private String libelle;
    private String pieceRattachement;
    private Integer pourcentageFermeture;
    private Integer etat;
    // Un volet doit être nécessairement attaché à un user
    private String emailUser;

}
