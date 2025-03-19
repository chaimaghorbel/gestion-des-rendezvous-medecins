package com.Projet_pfe.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Secretaire extends Utilisateur{
	
@ManyToOne
@JoinColumn(name="medecin_id",nullable=true)
private Medecin medecin;
public Medecin getMedecin() {
    return medecin;
}
public void setMedecin(Medecin medecin) {
    this.medecin = medecin;
}
}
