package com.Projet_pfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projet_pfe.entity.Medecin;
import com.Projet_pfe.entity.Patient;
import com.Projet_pfe.service.InscriptionService;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {
	 @Autowired
	    private InscriptionService inscriptionService;

	    @PostMapping("/medecin")
	    public String inscrireMedecin(@RequestBody Medecin medecin) {
	        inscriptionService.inscrireUtilisateur("medecin", medecin);
	        return "Médecin inscrit avec succès";
	    }

	    @PostMapping("/patient")
	    public String inscrirePatient(@RequestBody Patient patient) {
	        inscriptionService.inscrireUtilisateur("patient", patient);
	        return "Patient inscrit avec succès";
	    }
}
