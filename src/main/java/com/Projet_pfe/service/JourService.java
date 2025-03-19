package com.Projet_pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.DeclarationAbsenceRepository;
import com.Projet_pfe.entity.Jour;
@Service
public class JourService {
	  @Autowired
	    private DeclarationAbsenceRepository declarationAbsenceRepository;

	    public Jour saveJour(Jour jour) {
	        return declarationAbsenceRepository.save(jour);
	    }

	    public Jour getJourById(Long id) {
	        return (Jour) declarationAbsenceRepository.findById(id).orElse(null);
	    }
}
