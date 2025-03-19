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

import com.Projet_pfe.entity.Rendezvous;
import com.Projet_pfe.service.RendezVousService;

@RestController
@RequestMapping("/rendezVous")
public class RendezVousController {
	@Autowired
	RendezVousService rendService;
	@PostMapping("/add")
	public ResponseEntity<Void> ajouterRendezVous(@RequestBody Rendezvous Rendezvous) {
	    rendService.ajouterRe(Rendezvous);
	    return new ResponseEntity<>(HttpStatus.CREATED); // Code HTTP 201 pour la création
	}

	@GetMapping("/")
    public ResponseEntity<List<Rendezvous>> getAllMedecins() {
        List<Rendezvous> medecins = rendService.getAllRendezVous();
        return new ResponseEntity<>(medecins, HttpStatus.OK);
    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Rendezvous> update(@PathVariable Long id, @RequestBody Rendezvous updated) {
		 Rendezvous medecin = rendService.updateRendez(id, updated);
	        if (medecin != null) {
	            return new ResponseEntity<>(medecin, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @PutMapping("/{id}/valider")
	    public ResponseEntity<Rendezvous> validerRendezVous(@PathVariable Long id) {
	        Rendezvous rendezvous = rendService.validerRendezVous(id);
	        return ResponseEntity.ok(rendezvous);
	    }

	  
	    @PutMapping("/{id}/annuler")
	    public ResponseEntity<Rendezvous> annulerRendezVous(@PathVariable Long id) {
	        Rendezvous rendezvous = rendService.annulerRendezVous(id);
	        return ResponseEntity.ok(rendezvous);
	    }
	 
		@GetMapping("/{id}")
		public ResponseEntity<Rendezvous> trouverUtilisateurParId(@PathVariable Long id) {
		    Optional<Rendezvous> utilisateur = rendService.getMRendezVousById(id);
		    if (utilisateur.isPresent()) {
		        return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		}
		
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRendez(@PathVariable Long id) {
		 rendService.deleteRendezVous(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	 
}
