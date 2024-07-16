package com.rhc.controller;

import com.rhc.entity.Conge;
import com.rhc.entity.StatusConge;
import com.rhc.service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conges")
public class CongeController {
    @Autowired
    private CongeService congeService;

    @GetMapping
    public List<Conge> getAllConges() {
        return congeService.getAllConges();
    }

    @GetMapping("/employe/{idEmploye}")
    public List<Conge> getCongesByEmploye(@PathVariable int idEmploye) {
        return congeService.getCongesByEmploye(idEmploye);
    }

    @PostMapping
    public Conge createConge(@RequestBody Conge conge) {
        conge.setStatus(StatusConge.EN_ATTENTE);
        return congeService.saveConge(conge);
    }

    @PutMapping("/{idDemande}/status")
    public Conge updateStatus(@PathVariable int idDemande, @RequestBody StatusConge status) {
        return congeService.updateStatus(idDemande, status);
    }

    @DeleteMapping("/{idDemande}")
    public void deleteConge(@PathVariable int idDemande) {
        congeService.deleteConge(idDemande);
    }
}
