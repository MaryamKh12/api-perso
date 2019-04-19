package org.project.controller;


import org.project.service.VoletService;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoletController {

    private VoletService voletService;

    public VoletController(VoletService voletService) {
        this.voletService = voletService;
    }



    @PostMapping("/volets")
    public String addVolet(@RequestParam String numero,
                           @RequestParam String libelle,
                           @RequestParam String pieceRattachement,
                           @RequestParam Integer pourcentageFermeture,
                           @RequestParam Integer etat) {
        return voletService.addVolet(numero, libelle, pieceRattachement, pourcentageFermeture, etat);
    }

    @DeleteMapping("/volets/{numero}")
    public void deleteVolet(@PathVariable String numero) {
        voletService.deleteVolet(numero);
    }

    @PutMapping("/volets/{numero}")
    public void changeDegreVolet(@PathVariable String numero, @RequestParam Integer degreOuv) {
        voletService.changeDegreVolet(numero,degreOuv);
    }

    @GetMapping("/volets/{numero}")
    public Integer voletState(@PathVariable String numero) {
        return voletService.findVoletState(numero);
    }
}
