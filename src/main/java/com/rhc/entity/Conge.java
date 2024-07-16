package com.rhc.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemande;
    private int idEmploye;
    private Date dateDebut;
    private Date dateFin;

    @Enumerated(EnumType.STRING)
    private StatusConge  status;

    @ManyToOne
    @JoinColumn(name = "idEmploye", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public StatusConge getStatus() {
        return status;
    }

    public void setStatus(StatusConge status) {
        this.status = status;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
