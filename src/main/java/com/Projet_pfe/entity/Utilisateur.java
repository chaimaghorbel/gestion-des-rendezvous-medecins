package com.Projet_pfe.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "utilisateur", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nomUser"),
        @UniqueConstraint(columnNames = "telephone")
})
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	 @Column(nullable = false)
	String nom;
	 @Column(nullable = false)
	String prenom;
	  @Column(nullable = false, unique = true)
	String nomUser;
	  @Column(nullable = false)
	String motDePasse;
	LocalDate datInsPlatf;
	LocalDate datNaissance;
	  @Column(nullable = false)
	String telephone;
	String sexe;
	String nationalite;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role; 
	

}
