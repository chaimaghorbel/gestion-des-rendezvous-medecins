package com.Projet_pfe.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Medecin extends Utilisateur {
	@Column(nullable = false, unique = true)
	String prenomMedecin;
	@Column(nullable = true)
	private String niomt;
	@Column(nullable = false)
	String specialite;
	int anneeDiplome;
	String université;

	@PrePersist
	public void generateNom() {
		if (this.prenomMedecin == null || this.prenomMedecin.isEmpty()) {
			// Assurer que le nom est généré sous la forme "Dr. [Prenom]"
			this.prenomMedecin = "Dr. " + this.getPrenom();
		}
	}

	@JsonIgnore
	@OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
	private List<Secretaire> secretaires;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
	private List<Rendezvous> rendezVous;
	@JsonIgnore
	@OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
	private List<DeclarationAbsence> absences;
	  @JsonIgnore 
	@OneToMany(mappedBy = "medecin")
    private List<Consultation> consultations;
	

}
