package com.Projet_pfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Projet_pfe.entity.Secretaire;
import com.Projet_pfe.service.SecritaireService;

@RestController
@RequestMapping("/secritaire")
public class SecritaireController {
	@Autowired
	SecritaireService service;
	@PostMapping("/add")
	  public ResponseEntity<Secretaire> ajouterSecretaire(@RequestBody Secretaire medecin) {
		Secretaire createdMedecin = service.ajouterMedecin(medecin);
      return new ResponseEntity<>(createdMedecin, HttpStatus.CREATED);
  }
	


}
