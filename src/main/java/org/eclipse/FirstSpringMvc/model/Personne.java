package org.eclipse.FirstSpringMvc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "personnes")
public class Personne implements Serializable {
	@Id
	@GeneratedValue
	private int num;
	@Size(min = 2)
	@NotEmpty(message ="le nom doit etre saisi")
	private String nom;
	@Size(min = 2)
	@NotEmpty(message ="le prenom doit etre saisi")
	private String prenom;
	//private static final long serialVersionUID = 1L;

	public Personne() {
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Personne [num=" + num + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
