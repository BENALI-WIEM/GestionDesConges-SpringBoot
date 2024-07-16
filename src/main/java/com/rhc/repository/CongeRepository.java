package com.rhc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rhc.entity.Conge;

import java.util.List;

public interface CongeRepository extends JpaRepository<Conge, Integer> {
    List<Conge> findByIdEmploye(int idEmploye);
}