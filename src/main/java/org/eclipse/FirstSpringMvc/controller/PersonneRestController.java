package org.eclipse.FirstSpringMvc.controller;

import java.util.List;

import org.eclipse.FirstSpringMvc.dao.AdresseRepository;
import org.eclipse.FirstSpringMvc.dao.PersonneRepository;
import org.eclipse.FirstSpringMvc.model.Adresse;
import org.eclipse.FirstSpringMvc.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneRestController {
	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private AdresseRepository adresseRepository;

	@GetMapping("/personnes")
	public List<Personne> getPersonnes() {
		return personneRepository.findAll();
	}

	@GetMapping("/personnes/{id}")
	public Personne getPersonne(@PathVariable("id") long id) {
		return personneRepository.findById(id).orElse(null);
	}

	@PostMapping("/personnes")
	public Personne addPersonne(@RequestBody Personne personne) {
		System.out.println(personne);
		List<Adresse> adresses = personne.getAdresses();
		for (Adresse adresse : adresses) {
			Adresse adr = null;
			if (adresse.getId() != null) {
				adr = adresseRepository.findById(adresse.getId()).orElse(null);
				adresses.set(adresses.indexOf(adresse), adr);
			} else {
				adr = adresseRepository.save(adresse);
			}
		}
		return personneRepository.saveAndFlush(personne);
	}

	@PostMapping("/delpersonnes/{id}")
	public boolean deletePersonne(@PathVariable("id") long id) {
		Personne personne = personneRepository.findById(id).orElse(null);
		// System.out.println(personne);
		// personneRepository.delete(personneRepository.findById(id).orElse(null));
		// personneRepository.deleteById(id);
		if (personne != null) {
			personneRepository.delete(personne);
			return true;
		}
		return false;
	}

	@PostMapping("/putpersonnes")
	public Personne putPersonne(@RequestBody Personne personne) {
		return personneRepository.saveAndFlush(personne);
		/*Personne p = personneRepository.findById(personne.getNum()).orElse(null);
		if (p != null) {
			// p.setNom(personne.getNom());
			// p.setPrenom(personne.getPrenom());
			p = personne;
			return personneRepository.saveAndFlush(p);
		}
		return p;*/
	}

}