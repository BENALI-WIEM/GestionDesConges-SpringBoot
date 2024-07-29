package com.rhc.service;

import com.rhc.entity.Conge;
import com.rhc.entity.StatusConge;
import com.rhc.entity.Utilisateur;
import com.rhc.repository.CongeRepository;
import com.rhc.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongeService {
    @Autowired
    private CongeRepository congeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Conge demanderConge(Conge conge, int idUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        conge.setUtilisateur(utilisateur);
        conge.setStatus(StatusConge.EN_ATTENTE);
        return congeRepository.save(conge);
    }

    public Conge validerConge(int idDemande, StatusConge status) {
        Conge conge = congeRepository.findById(idDemande)
                .orElseThrow(() -> new RuntimeException("Congé non trouvé"));
        conge.setStatus(status);
        return congeRepository.save(conge);
    }

    public List<Conge> getCongesUtilisateur(int idUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        return congeRepository.findByUtilisateur(utilisateur);
    }

    public List<Conge> getAllConges() {
        return congeRepository.findAll();
    }

    public List<Conge> getHistoriqueConges(int idUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        return congeRepository.findByUtilisateur(utilisateur);
    }
}