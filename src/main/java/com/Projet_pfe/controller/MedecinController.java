package com.Projet_pfe.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projet_pfe.entity.DeclarationAbsence;
import com.Projet_pfe.entity.Medecin;
import com.Projet_pfe.entity.Utilisateur;
import com.Projet_pfe.service.MedecinService;

import jakarta.persistence.EntityNotFoundException;
@RestController
@RequestMapping("/Medecin")
public class MedecinController {
	@Autowired
	MedecinService medSer;
	
	@PostMapping("/add")
	  public ResponseEntity<Medecin> ajouterMedecin(@RequestBody Medecin medecin) {
        Medecin createdMedecin = medSer.ajouterMedecin(medecin);
        return new ResponseEntity<>(createdMedecin, HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Utilisateur> trouverUtilisateurParId(@PathVariable Long id) {
	    Optional<Medecin> utilisateur = medSer.findById(id);
	    if (utilisateur.isPresent()) {
	        return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	 @GetMapping("/")
	    public ResponseEntity<List<Medecin>> getAllMedecins() {
	        List<Medecin> medecins = medSer.getAllMedecins();
	        return new ResponseEntity<>(medecins, HttpStatus.OK);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Medecin> updateMedecin(@PathVariable Long id, @RequestBody Medecin updatedMedecin) {
	        Medecin medecin = medSer.updateMedecin(id, updatedMedecin);
	        if (medecin != null) {
	            return new ResponseEntity<>(medecin, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Supprimer un médecin
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteMedecin(@PathVariable Long id) {
	    	medSer.deleteMedecin(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/specialite/{specialite}")
	    public List<Medecin> findBySpecialite(@PathVariable String specialite) {
	        return medSer.findBySpecialite(specialite);
	    }
	   
	  

	    @GetMapping("/{id}/absences")
	    public List<DeclarationAbsence> getAbsencesByMedecin(@PathVariable Long id) {
	        return medSer.getAbsencesByMedecin(id);
	    }

	    @PostMapping("/{id}/absences")
	    public ResponseEntity<String> addAbsenceToMedecin(@PathVariable Long id, @RequestBody DeclarationAbsence absence) {
	        try {
	            medSer.addAbsenceToMedecin(id, absence);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Absence ajoutée avec succès !");
	        } catch (EntityNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }
	    
	    
}
