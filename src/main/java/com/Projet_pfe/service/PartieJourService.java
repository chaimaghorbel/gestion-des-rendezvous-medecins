package com.Projet_pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.DeclarationAbsenceRepository;
import com.Projet_pfe.entity.PartieJour;
@Service
public class PartieJourService {
	 @Autowired
	    private DeclarationAbsenceRepository declarationAbsenceRepository;

	    public PartieJour savePartieJour(PartieJour partieJour) {
	        return (PartieJour) declarationAbsenceRepository.save(partieJour);
	    }

	    public PartieJour getPartieJourById(Long id) {
	        return (PartieJour) declarationAbsenceRepository.findById(id).orElse(null);
	    }
}
