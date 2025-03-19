package com.Projet_pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.ConsultationRepository;
import com.Projet_pfe.entity.Consultation;
@Service
public class ConsultationService {
	@Autowired
	 private  ConsultationRepository consultationRepo;
	 
	 public List<Consultation> getAllConsultations() {
	        return consultationRepo.findAll();
	    }

	    public Consultation saveConsultation(Consultation consultation) {
	        return consultationRepo.save(consultation);
	    }
	    public List<Consultation> getConsultationsByPatient(Long patientId) {
	        return consultationRepo.findByPatientId(patientId);
	    }

	    public List<Consultation> getConsultationsByMedecin(Long medecinId) {
	        return consultationRepo.findByMedecinId(medecinId);
	    }
	    public List<Consultation> getConsultationsByPatientNomUser(String nomUser) {
	        return consultationRepo.findByPatientNomUser(nomUser);
	    }
}
