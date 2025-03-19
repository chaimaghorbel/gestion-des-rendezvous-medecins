package com.Projet_pfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.DeclarationAbsenceRepository;
import com.Projet_pfe.Repository.MedecinRepository;
import com.Projet_pfe.entity.DeclarationAbsence;
import com.Projet_pfe.entity.Jour;
import com.Projet_pfe.entity.Medecin;
import com.Projet_pfe.entity.PartieJour;
import com.Projet_pfe.entity.Periode;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class MedecinService {
	@Autowired
	MedecinRepository MedRep;
	@Autowired
	private DeclarationAbsenceRepository declarationAbsenceRepository;

	public Medecin ajouterMedecin(Medecin medecin) {
		return MedRep.save(medecin);
	}

	
	public Optional<Medecin> getMedecinById(Long id) {
		return MedRep.findById(id);
	}

	// Récupérer tous les médecins
	public List<Medecin> getAllMedecins() {

		return MedRep.findAll();

	}

	public Medecin updateMedecin(Long id, Medecin updatedMedecin) {
		if (MedRep.existsById(id)) {
			updatedMedecin.setId(id); // Assigner l'ID pour la mise à jour
			return MedRep.save(updatedMedecin);
		}
		return null; // Retourner null si le médecin n'existe pas
	}

	// Supprimer un médecin par son ID
	public void deleteMedecin(Long id) {
		if (MedRep.existsById(id)) {
			MedRep.deleteById(id);
		}
	}

	// Trouver un médecin par sa spécialité
	public List<Medecin> findBySpecialite(String specialite) {
		return MedRep.findBySpecialite(specialite);
	}

	public Optional<Medecin> findById(Long id) {
		return MedRep.findById(id);
	}

	public List<DeclarationAbsence> getAbsencesByMedecin(Long medecinId) {
		Medecin medecin = MedRep.findById(medecinId).orElse(null);
		if (medecin != null) {
			return medecin.getAbsences();
		}
		return null;
	}
//	  @Autowired
//	    private PartieJourService partieJourService;
//
//	    @Autowired
//	    private JourService jourService;
//
//	    @Autowired
//	    private PeriodeService periodeService;

//	    public void addAbsenceToMedecin(Long medecinId, DeclarationAbsence absence) {
//	        Medecin medecin = MedRep.findById(medecinId).orElse(null);
//	        if (medecin != null) {
//	            // Associer le médecin à l'absence
//	            absence.setMedecin(medecin);
//
//	            // Vérifier de quel type d'absence il s'agit et appeler le service approprié
//	            if (absence instanceof PartieJour) {
//	                PartieJour partieJour = (PartieJour) absence;
//	                partieJourService.savePartieJour(partieJour); // Appel spécifique au service PartieJour
//	            } else if (absence instanceof Jour) {
//	                Jour jour = (Jour) absence;
//	                jourService.saveJour(jour); // Appel spécifique au service Jour
//	            } else if (absence instanceof Periode) {
//	                Periode periode = (Periode) absence;
//	                periodeService.savePeriode(periode); // Appel spécifique au service Periode
//	            } else {
//	                // Pour les autres types d'absence, utiliser un enregistrement général
//	                declarationAbsenceRepository.save(absence);
//	            }
//	        }
//	    }
	    

	  
	   

	    public void addAbsenceToMedecin(Long medecinId, DeclarationAbsence absence) {
	        Medecin medecin = MedRep.findById(medecinId)
	                .orElseThrow(() -> new EntityNotFoundException("Médecin non trouvé avec ID : " + medecinId));

	        if (absence == null) {
	            throw new IllegalArgumentException("L'absence ne peut pas être null");
	        }

	        absence.setMedecin(medecin);
	        declarationAbsenceRepository.save(absence); // Utilisation de save() au lieu de persist()
	    }}
	