package com.rhc.repository;

import com.rhc.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rhc.entity.Conge;

import java.time.LocalDate;
import java.util.List;

public interface CongeRepository extends JpaRepository<Conge, Integer> {
    List<Conge> findByUtilisateur(Utilisateur utilisateur);
    List<Conge> findByDateDebut(LocalDate dateDebut);

    List<Conge> findByIdEmploye(int idEmploye);
}