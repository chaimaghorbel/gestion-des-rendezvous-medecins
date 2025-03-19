package com.Projet_pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Projet_pfe.entity.Rendezvous;
@Repository
public interface RendezVousRepository extends JpaRepository<Rendezvous, Long> {
	
}
