package com.Projet_pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.DeclarationAbsenceRepository;
import com.Projet_pfe.entity.DeclarationAbsence;
@Service
public class DeclarationAbsenceService {
	  @Autowired
	    private DeclarationAbsenceRepository declarationAbsenceRepository;

	    public DeclarationAbsence saveAbsence(DeclarationAbsence absence) {
	        return declarationAbsenceRepository.save(absence);
	    }

	    public List<DeclarationAbsence> getAllAbsences() {
	        return declarationAbsenceRepository.findAll();
	    }

	    public DeclarationAbsence getAbsenceById(Long id) {
	        return declarationAbsenceRepository.findById(id).orElse(null);
	    }
}
