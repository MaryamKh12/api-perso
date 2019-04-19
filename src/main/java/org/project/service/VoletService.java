package org.project.service;

import org.project.model.Volet;
import org.project.repository.VoletRepository;
import org.springframework.stereotype.Service;

@Service
public class VoletService {

    private VoletRepository voletRepository;

    public VoletService(VoletRepository voletRepository) {
        this.voletRepository = voletRepository;
    }

    public String addVolet(final String numero,
                           final String libelle,
                           final String pieceRattachement,
                           final Integer pourcentageFermeture,
                           final Integer etat){
        Volet addedVolet = voletRepository.save(new Volet(numero, libelle, pieceRattachement, pourcentageFermeture, etat, null));
        return addedVolet.getNumero();
    }

    public void deleteVolet(final String numero){
        voletRepository.delete(numero);
    }

    public void changeDegreVolet(final String numero, final Integer degre){
        Volet foundVolet = voletRepository.findOne(numero);
        foundVolet.setPourcentageFermeture(degre);
        voletRepository.save(foundVolet);
    }


    public Integer findVoletState(final String numero){
        Volet foundVolet = voletRepository.findOne(numero);
        return foundVolet != null ? foundVolet.getEtat() : null;
    }
}
