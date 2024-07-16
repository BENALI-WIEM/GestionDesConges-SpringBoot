package com.rhc.service;

import com.rhc.entity.Conge;
import com.rhc.entity.StatusConge;
import com.rhc.repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongeService {
    @Autowired
    private CongeRepository congeRepository;

    public List<Conge> getAllConges() {
        return congeRepository.findAll();
    }

    public List<Conge> getCongesByEmploye(int idEmploye) {
        return congeRepository.findByIdEmploye(idEmploye);
    }

    public Conge saveConge(Conge conge) {
        return congeRepository.save(conge);
    }

    public void deleteConge(int idDemande) {
        congeRepository.deleteById(idDemande);
    }

    public Conge updateStatus(int idDemande, StatusConge status) {
        Conge conge = congeRepository.findById(idDemande).orElse(null);
        if (conge != null) {
            conge.setStatus(status);
            return congeRepository.save(conge);
        }
        return null;
    }
}