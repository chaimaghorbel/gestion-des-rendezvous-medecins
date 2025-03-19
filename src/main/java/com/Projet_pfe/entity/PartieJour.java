package com.Projet_pfe.entity;

import java.time.LocalTime;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("PARTIE_JOUR")

public class PartieJour extends DeclarationAbsence {
	
	 private LocalTime heureDebut;
	    private LocalTime heureFin;
	    
}
