package com.Projet_pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.MedecinRepository;
import com.Projet_pfe.Repository.PatientRepository;
import com.Projet_pfe.entity.Medecin;
import com.Projet_pfe.entity.Patient;
import com.Projet_pfe.entity.Utilisateur;

@Service
public class InscriptionService {
	@Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private PatientRepository patientRepository;
    
    public void inscrireUtilisateur(String type, Utilisateur utilisateur) {
        if (type.equals("medecin")) {
            medecinRepository.save((Medecin) utilisateur);
        } else if (type.equals("patient")) {
            patientRepository.save((Patient) utilisateur);
        }
    }
}
