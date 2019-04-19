package org.project.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class UtilisateurController {

    @PostMapping("/users")
    public String addUser(@RequestParam String nom,
                          @RequestParam String email) {
        return null;
    }

    @DeleteMapping("/users/{email}")
    public Void deleteUser(@PathVariable String email) {
        return null;
    }

    /* TODO
    public String addVoletsToUser() {
        return null;
    }

    public String removeVoletsFromUser() {
        return null;
    }
*/
}
