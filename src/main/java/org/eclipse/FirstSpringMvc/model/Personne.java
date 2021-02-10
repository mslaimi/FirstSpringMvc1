package org.eclipse.FirstSpringMvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "personnes")
public class Personne implements Serializable {
	@Id
	@GeneratedValue
	private Long num;
	@Size(min = 2)
	@NotEmpty(message = "le champ nom est obligatoire")
	private String nom;
	@Size(min = 2)
	@NotEmpty(message = "le champ prenom est obligatoire")
	private String prenom;
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<Adresse> adresses = new ArrayList<Adresse>();
	private static final long serialVersionUID = 1L;

	public Personne() {
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(String nom, String prenom, List<Adresse> adresses) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresses = adresses;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
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

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public boolean add(Adresse e) {
		return adresses.add(e);
	}

	public boolean remove(Adresse e) {
		return adresses.remove(e);
	}

	@Override
	public String toString() {
		return "Personne [num=" + num + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
