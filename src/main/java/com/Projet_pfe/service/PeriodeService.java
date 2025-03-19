package com.Projet_pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.DeclarationAbsenceRepository;
import com.Projet_pfe.entity.Periode;
@Service
public class PeriodeService {
	 @Autowired
	    private DeclarationAbsenceRepository declarationAbsenceRepository;

	    public Periode savePeriode(Periode periode) {
	        return (Periode) declarationAbsenceRepository.save(periode);
	    }

	    public Periode getPeriodeById(Long id) {
	        return (Periode) declarationAbsenceRepository.findById(id).orElse(null);
	    }
}
