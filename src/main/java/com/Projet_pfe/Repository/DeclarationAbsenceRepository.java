package com.Projet_pfe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Projet_pfe.entity.DeclarationAbsence;

public interface DeclarationAbsenceRepository extends JpaRepository<DeclarationAbsence, Long> {
	 List<DeclarationAbsence> findByMedecinId(Long medecinId);
}
