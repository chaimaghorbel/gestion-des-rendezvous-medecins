package com.Projet_pfe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Projet_pfe.entity.Patient;
import com.Projet_pfe.entity.Utilisateur;
import com.Projet_pfe.service.PatientService;

@RestController
@RequestMapping("/Patient")
public class PatientConrtroller {
@Autowired
PatientService patSer;
@PostMapping("/add")
public ResponseEntity<Patient> ajouterMedecin(@RequestBody Patient Patient) {
	Patient createdMedecin = patSer.ajouterPatient(Patient);
  return new ResponseEntity<>(createdMedecin, HttpStatus.CREATED);
}

@GetMapping("/{id}")
public ResponseEntity<Utilisateur> trouverUtilisateurParId(@PathVariable Long id) {
  Optional<Patient> utilisateur = patSer.findById(id);
  if (utilisateur.isPresent()) {
      return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
  } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}

@GetMapping("/")
  public ResponseEntity<List<Patient>> getAllPatient() {
      List<Patient> Patient = patSer.getAllPatients();
      return new ResponseEntity<>(Patient, HttpStatus.OK);
  }

@PutMapping("/{id}")
  public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatePatient) {
	Patient Patient = patSer.updatePatient(id, updatePatient);
      if (Patient != null) {
          return new ResponseEntity<>(Patient, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
	  patSer.deletePatient(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
