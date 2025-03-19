package com.Projet_pfe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projet_pfe.entity.Medecin;
@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	public  List<Medecin> findBySpecialite(String specialite);
}
