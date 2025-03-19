package com.Projet_pfe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projet_pfe.entity.Consultation;
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
	 List<Consultation> findByPatientId(Long patientId);
	    
	 List<Consultation> findByPatientNomUser(String nomUser);
	    List<Consultation> findByMedecinId(Long medecinId);	
}
