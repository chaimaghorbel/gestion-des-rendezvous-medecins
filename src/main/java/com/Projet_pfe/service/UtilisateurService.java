package com.Projet_pfe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Projet_pfe.Repository.UtilisateurRepository;
import com.Projet_pfe.entity.Utilisateur;

@Service
public class UtilisateurService {
@Autowired
UtilisateurRepository utiRep;

public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
	try{
		return utiRep.save(utilisateur);
	
	} 
	catch (DataIntegrityViolationException e) {
        if (e.getMessage().contains("Duplicate entry")) {
            throw new RuntimeException("Le nom d'utilisateur est déjà pris. Veuillez en choisir un autre.");
        } else {
            throw new RuntimeException("Une erreur s'est produite lors de la création du compte.");
        }
    }
}

public Optional<Utilisateur> trouverUtilisateurParId(Long id) {
    return utiRep.findById(id);
}

// Trouver un utilisateur par son nom d'utilisateur
public Optional<Utilisateur> trouverUtilisateurParNomUser(String nomUser) {
    return utiRep.findByNomUser(nomUser);
}

// Mettre à jour un utilisateur
public Utilisateur mettreAJourUtilisateur(Long id, Utilisateur utilisateurDetails) {
    Optional<Utilisateur> utilisateurOptional = utiRep.findById(id);
    if (utilisateurOptional.isPresent()) {
        Utilisateur utilisateur = utilisateurOptional.get();
        utilisateur.setNom(utilisateurDetails.getNom());
        utilisateur.setPrenom(utilisateurDetails.getPrenom());
        utilisateur.setNomUser(utilisateurDetails.getNomUser());
        utilisateur.setMotDePasse(utilisateurDetails.getMotDePasse());
        utilisateur.setDatInsPlatf(utilisateurDetails.getDatInsPlatf());
        utilisateur.setDatNaissance(utilisateurDetails.getDatNaissance());
        utilisateur.setTelephone(utilisateurDetails.getTelephone());
        utilisateur.setSexe(utilisateurDetails.getSexe());
        utilisateur.setNationalite(utilisateurDetails.getNationalite());
        return utiRep.save(utilisateur);
    } else {
        return null;  // Utilisateur non trouvé
    }
}

// Supprimer un utilisateur
public void supprimerUtilisateur(Long id) {
    utiRep.deleteById(id);
}

}
