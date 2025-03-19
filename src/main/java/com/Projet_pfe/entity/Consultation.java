package com.Projet_pfe.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private LocalDate dateConsulta;
	    private LocalTime heureConsulta;
	    private String observation;

	    
	    @ManyToOne
	    @JoinColumn(name = "patient_id", nullable = false)
	    private Patient patient;
	 
	    @ManyToOne
	    @JoinColumn(name = "medecin_id", nullable = false)
	    private Medecin medecin;
	
	    @OneToOne
	    @JoinColumn(name = "rendezvous_id", unique = true)
	    private Rendezvous rendezVous;

}
