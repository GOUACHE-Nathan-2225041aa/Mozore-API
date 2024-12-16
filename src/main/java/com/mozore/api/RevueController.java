package com.mozore.api;

import com.mozore.api.Model.Revue;
import com.mozore.api.Service.RevueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revues")
public class RevueController {

    @Autowired
    private RevueService revueService;

    // Récupérer les revues triées par titre
    @GetMapping("/par-titre")
    public List<Revue> getRevuesParTitre() {
        return revueService.getRevuesParTitre();
    }

    // Récupérer les revues triées par note
    @GetMapping("/par-note")
    public List<Revue> getRevuesParNote() {
        return revueService.getRevuesParNote();
    }

    // Récupérer une revue par son ID
    @GetMapping("/{id}")
    public Revue getUneRevueAvecSonId(@PathVariable String id) {
        return revueService.getUneRevueAvecSonId(id);
    }

    // Ajouter une nouvelle revue
    @PostMapping
    public Revue ajouterRevue(@RequestBody Revue revue) {
        return revueService.ajouterRevue(revue);
    }

    // Modifier une revue existante
    @PutMapping("/{id}")
    public Revue modifierRevue(@PathVariable String id, @RequestBody Revue revue) {
        return revueService.modifierRevue(id, revue);
    }

    // Supprimer une revue
    @DeleteMapping("/{id}")
    public void supprimerRevue(@PathVariable String id) {
        revueService.supprimerRevue(id);
    }
}
