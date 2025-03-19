package com.Projet_pfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.PatientRepository;
import com.Projet_pfe.entity.Patient;

@Service
public class PatientService {
	@Autowired
	PatientRepository PatRep;
	 public Patient ajouterPatient(Patient Patient) {
	        return PatRep.save(Patient);
	    }
	  public Optional<Patient> getPatientById(Long id) {
	        return PatRep.findById(id);
	    }

	    public List<Patient> getAllPatients() {
	      
				return PatRep.findAll();
			
	    }
	    public Patient updatePatient(Long id, Patient updatePatient) {
	        if (PatRep.existsById(id)) {
	        	updatePatient.setId(id); 
	            return PatRep.save(updatePatient);
	        }
	        return null; 
	    }

	 
	    public void deletePatient(Long id) {
	        if (PatRep.existsById(id)) {
	        	PatRep.deleteById(id);
	        }
	    }
	    public List<Patient> findByPrenom(String Prenom) {
	        return PatRep.findByPrenom(Prenom);

}
	    public Optional<Patient> findById(Long id) {
	        return PatRep.findById(id);
	    }	    

}
