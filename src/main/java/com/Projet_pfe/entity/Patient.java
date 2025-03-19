package com.Projet_pfe.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;

@Entity
public class Patient extends Utilisateur {
	 @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
@JsonIgnore
	    private List<Rendezvous> rendezVous;
	  @JsonIgnore 
	 @OneToMany(mappedBy = "patient")
	    private List<Consultation> consultations;
}
