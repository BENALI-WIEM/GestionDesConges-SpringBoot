package com.rhc.controller;

import com.rhc.entity.Conge;
import com.rhc.entity.StatusConge;
import com.rhc.service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/conges")
public class CongeController {
    @Autowired
    private CongeService congeService;

    @PostMapping
    public Conge demanderConge(@RequestBody Conge conge, @RequestParam int idUtilisateur) {
        return congeService.demanderConge(conge, idUtilisateur);
    }

    @PutMapping("/{idDemande}")
    public Conge validerConge(@PathVariable int idDemande, @RequestParam StatusConge status) {
        return congeService.validerConge(idDemande, status);
    }

    @GetMapping("/utilisateur/{idUtilisateur}")
    public List<Conge> getCongesUtilisateur(@PathVariable int idUtilisateur) {
        return congeService.getCongesUtilisateur(idUtilisateur);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")

    public List<Conge> getAllConges() {
        return congeService.getAllConges();
    }

    @GetMapping("/utilisateur/{idUtilisateur}/historique")
    public List<Conge> getHistoriqueConges(@PathVariable int idUtilisateur) {
        return congeService.getHistoriqueConges(idUtilisateur);
    }
}