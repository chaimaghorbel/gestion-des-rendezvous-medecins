package com.Projet_pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.SecritaireRepository;
import com.Projet_pfe.entity.Secretaire;
@Service
public class SecritaireService {
@Autowired
SecritaireRepository serRep;

public Secretaire ajouterMedecin(Secretaire medecin) {
    return serRep.save(medecin);
}

}
