package org.project.controller;


import org.project.model.Volet;
import org.project.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/users")
    public String addUser(@RequestParam String nom,
                          @RequestParam String email) {
        return utilisateurService.addUtilisateur(nom, email);
    }

    @DeleteMapping("/users/{email}")
    public void deleteUser(@PathVariable String email) {
         utilisateurService.deleteUtilisateur(email);
    }

    @PostMapping("/users/{email}")
    public List<Volet> addVoletsToUser(@PathVariable String email, @RequestParam List<String> volets) {
        return utilisateurService.addVoletsToUtilisateur(email, volets);
    }
}
