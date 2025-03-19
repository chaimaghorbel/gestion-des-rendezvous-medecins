package com.Projet_pfe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projet_pfe.Repository.MedecinRepository;
import com.Projet_pfe.entity.Medecin;
import com.Projet_pfe.entity.Patient;
import com.Projet_pfe.entity.Role;
import com.Projet_pfe.entity.Secretaire;
import com.Projet_pfe.entity.Utilisateur;
import com.Projet_pfe.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
@Autowired
UtilisateurService utiSer;
@PostMapping("/inscription/medecin")
public ResponseEntity<?> inscrireMedecin(@RequestBody Medecin medecin) {
	 try {
	        medecin.setRole(Role.MEDECIN); 
	        utiSer.ajouterUtilisateur(medecin);
	        return ResponseEntity.ok("Médecin inscrit avec succès");
	 } catch (RuntimeException e) {
	        throw e; 
	    }
	}

@PostMapping("/inscription/patient")
public ResponseEntity<?> inscrirePatient(@RequestBody Patient patient) {
	 try {  patient.setRole(Role.PATIENT); 
    utiSer.ajouterUtilisateur(patient);
    return ResponseEntity.ok("Patient inscrit avec succès");
	 } catch (RuntimeException e) {
	        throw e; 
	    }}
@Autowired
MedecinRepository medecinRepository;
@PostMapping("/inscription/secretaire")
public ResponseEntity<?> inscrireSecretaire(@RequestBody Secretaire secretaire) {
    if (secretaire.getMedecin() != null && secretaire.getMedecin().getId() != null) {
        // Vérifier si le médecin existe
        Optional<Medecin> medecinOptional = medecinRepository.findById(secretaire.getMedecin().getId());
        if (medecinOptional.isPresent()) {
            secretaire.setMedecin(medecinOptional.get());
        } else {
            return ResponseEntity.badRequest().body("Médecin non trouvé");
        }
    }
    secretaire.setRole(Role.SECRETAIRE);
    utiSer.ajouterUtilisateur(secretaire);
    return ResponseEntity.ok("Secrétaire inscrit avec succès");
}

@PostMapping("/add")
public ResponseEntity<Utilisateur> ajouterUtilisateur(@RequestBody Utilisateur uti) {
  Utilisateur createdUtilisateur = utiSer.ajouterUtilisateur(uti);
  return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
}

@GetMapping("/{id}")
public ResponseEntity<Utilisateur> trouverUtilisateurParId(@PathVariable Long id) {
    Optional<Utilisateur> utilisateur = utiSer.trouverUtilisateurParId(id);
    if (utilisateur.isPresent()) {
        return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
}
