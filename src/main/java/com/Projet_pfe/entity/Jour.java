package com.Projet_pfe.entity;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity

@DiscriminatorValue("JOUR")

public class Jour extends DeclarationAbsence {

}
