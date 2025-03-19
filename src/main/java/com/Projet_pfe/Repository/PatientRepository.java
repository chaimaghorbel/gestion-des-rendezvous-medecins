package com.Projet_pfe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projet_pfe.entity.Patient;

@Repository

public interface PatientRepository extends JpaRepository<Patient, Long> {
	public  List<Patient> findByPrenom(String Prenom);

}
