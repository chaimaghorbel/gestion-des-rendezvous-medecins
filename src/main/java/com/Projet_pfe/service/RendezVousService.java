package com.Projet_pfe.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.RendezVousRepository;
import com.Projet_pfe.entity.EtatRendezVous;
import com.Projet_pfe.entity.Medecin;
import com.Projet_pfe.entity.Patient;
import com.Projet_pfe.entity.Rendezvous;

@Service
public class RendezVousService {
@Autowired 
RendezVousRepository RenRep;
public Rendezvous ajouterRe(Rendezvous Ren) {
    return RenRep.save(Ren);
}
public Rendezvous prendreRendezVous(Patient patient, Medecin medecin, LocalDate dateRDV, LocalTime heureRDV) {
    
    Rendezvous rendezvous = new Rendezvous();
    
    rendezvous.setPatient(patient);  
    rendezvous.setMedecin(medecin);  
    rendezvous.setDatRDV(dateRDV);  
    rendezvous.setHeurRDV(heureRDV); 
    rendezvous.setEtat(EtatRendezVous.EN_ATTENTE);  
    
    Rendezvous savedRendezvous = RenRep.save(rendezvous);

    return savedRendezvous;  
}

public List<Rendezvous> getAllRendezVous() {
	return RenRep.findAll();

}
public void deleteRendezVous(Long id) {
    if (RenRep.existsById(id)) {
    	RenRep.deleteById(id);
    }
    
}
public Optional<Rendezvous> getMRendezVousById(Long id) {
    return RenRep.findById(id);
}
public Rendezvous validerRendezVous(Long id) {
    return updateEtatRendezVous(id, EtatRendezVous.CONFIRME);
}

// Annuler un rendez-vous
public Rendezvous annulerRendezVous(Long id) {
    return updateEtatRendezVous(id, EtatRendezVous.REFUSE);
}

private Rendezvous updateEtatRendezVous(Long id, EtatRendezVous nouvelEtat) {
    Optional<Rendezvous> optionalRendezvous = RenRep.findById(id);

    if (optionalRendezvous.isPresent()) {
        Rendezvous rendezvous = optionalRendezvous.get();
        rendezvous.setEtat(nouvelEtat); // Mettre à jour l'état
        return RenRep.save(rendezvous); // Sauvegarder les modifications
    } else {
        throw new RuntimeException("Rendez-vous non trouvé avec l'ID : " + id);
    }
}
public Rendezvous updateRendez(Long id, Rendezvous updateRendezvous) {
    if (RenRep.existsById(id)) {
    	updateRendezvous.setId(id); 
        return RenRep.save(updateRendezvous);
    }
    return null; 
}

}
