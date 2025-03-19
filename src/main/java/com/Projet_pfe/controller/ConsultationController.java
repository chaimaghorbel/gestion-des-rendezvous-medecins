package com.Projet_pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projet_pfe.entity.Consultation;
import com.Projet_pfe.service.ConsultationService;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {
	@Autowired
      ConsultationService consultationService;
	 
	@GetMapping("/all")
	    public List<Consultation> getAllConsultations() {
	        return consultationService.getAllConsultations();
	    }

	    @PostMapping("/add")
	    public Consultation createConsultation(@RequestBody Consultation consultation) {
	        return consultationService.saveConsultation(consultation);
	    }
	    @GetMapping("/patient/{patientId}")
	    public List<Consultation> getConsultationsByPatient(@PathVariable Long patientId) {
	        return consultationService.getConsultationsByPatient(patientId);
	    }

	    // Afficher les consultations d'un médecin
	    @GetMapping("/medecin/{medecinId}")
	    public List<Consultation> getConsultationsByMedecin(@PathVariable Long medecinId) {
	        return consultationService.getConsultationsByMedecin(medecinId);
	    }
	    @GetMapping("/patient/nom/{nomUser}")
	    public List<Consultation> getConsultationsByPatientNomUser(@PathVariable String nomUser) {
	        return consultationService.getConsultationsByPatientNomUser(nomUser);
	    }
}
