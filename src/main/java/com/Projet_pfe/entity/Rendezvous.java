package com.Projet_pfe.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rendezvous {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 @Column(name = "DateRDV", nullable = false)
	    private LocalDate datRDV;
	 @Enumerated(EnumType.STRING) // Mapper l'enum en tant que chaîne de caractères
	 @Column(name = "Etat", nullable = false)
	 private EtatRendezVous etat = EtatRendezVous.EN_ATTENTE; // Initialisation par défaut
	    @Column(name = "HeureRDV", nullable = false)
	    private LocalTime heurRDV;
	    
	    @ManyToOne
	    @JoinColumn(name = "patient_id", nullable = false)
	    private Patient patient;

	    // Clé étrangère vers Medecin
	    @ManyToOne
	    @JoinColumn(name = "medecin_id", nullable = false)
	    private Medecin medecin;
	    @JsonIgnore 
	    @OneToOne(mappedBy = "rendezVous")
	    private Consultation consultation;
	    
}
