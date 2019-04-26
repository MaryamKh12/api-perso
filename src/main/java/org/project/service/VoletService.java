package org.project.service;

import org.project.model.Utilisateur;
import org.project.model.Volet;
import org.project.repository.UtilisateurRepository;
import org.project.repository.VoletRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class VoletService {

    private VoletRepository voletRepository;
    private UtilisateurService utilisateurService;

    public VoletService(VoletRepository voletRepository,  UtilisateurService utilisateurService) {
        this.voletRepository = voletRepository;
        this.utilisateurService = utilisateurService;
    }

    public Integer addVolet(final Integer numero,
                                       final String libelle,
                                       final String pieceRattachement,
                                       final Integer pourcentageFermeture,
                                       final Integer etat,
                                       final String email){
       Volet volet = getVoletToAdd(numero, libelle, pieceRattachement, pourcentageFermeture, etat, email);
        if(volet != null) {
            Volet addedVolet = voletRepository.save(volet);
            return addedVolet.getNumero();
        }
        return 404;
    }

    private Volet getVoletToAdd(final Integer numero,
                                final String libelle,
                                final String pieceRattachement,
                                final Integer pourcentageFermeture,
                                final Integer etat,
                                final String email) {
        if(email != null) {
            Utilisateur utilisateur = utilisateurService.findUser(email);
            return utilisateur != null ? new Volet(numero, libelle, pieceRattachement, pourcentageFermeture, etat, utilisateur): null;
        }
        return new Volet(numero, libelle, pieceRattachement, pourcentageFermeture, etat, null);
    }


    public void deleteVolet(final String numero){
        voletRepository.delete(numero);
    }

    public void changeDegreVolet(final String numero, final Integer degre){
        Volet foundVolet = voletRepository.findOne(numero);
        if(foundVolet != null) {
            foundVolet.setPourcentageFermeture(degre);
            voletRepository.save(foundVolet);
        }
    }


    public Integer findVoletState(final String numero){
        Volet foundVolet = voletRepository.findOne(numero);
        return foundVolet != null ? foundVolet.getEtat() : null;
    }

    public List<Volet> findVolets(final List<String> voletsNames) {
        return voletRepository.findAll(voletsNames);
    }

    public List<Volet> saveVolets(final List<Volet> volets) {
        return voletRepository.save(volets);
    }
}
