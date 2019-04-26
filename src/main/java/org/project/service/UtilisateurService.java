package org.project.service;

import org.project.model.Utilisateur;
import org.project.model.Volet;
import org.project.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {

    private VoletService voletService;
    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, VoletService voletService) {
        this.utilisateurRepository = utilisateurRepository;
        this.voletService = voletService;
    }


    public String addUtilisateur(final String nom,
                           final String email){
       Utilisateur utilisateur = utilisateurRepository.save(new Utilisateur(nom, email));
       return utilisateur.getNom();
    }

    public void deleteUtilisateur(final String email){
        utilisateurRepository.delete(email);
    }

    public List<Volet> addVoletsToUtilisateur(final String email, final List<String> volets){
        Utilisateur utilisateur = utilisateurRepository.findOne(email);
        List<Volet> foundVolets = voletService.findVolets(volets);
        List<Volet> voletsWithUser = foundVolets.stream().map(volet ->
                new Volet(volet.getNumero(), volet.getLibelle(), volet.getPieceRattachement(), volet.getPourcentageFermeture(), volet.getEtat(), utilisateur))
                .collect(Collectors.toList());

        return voletService.saveVolets(voletsWithUser);
    }

    public Utilisateur findUser(final String email) {
        return utilisateurRepository.findOne(email);
    }
}
