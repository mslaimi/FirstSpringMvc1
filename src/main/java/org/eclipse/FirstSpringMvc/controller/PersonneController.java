package org.eclipse.FirstSpringMvc.controller;

import java.util.List;

import org.eclipse.FirstSpringMvc.dao.PersonneRepository;
import org.eclipse.FirstSpringMvc.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneController {
	@Autowired
	private PersonneRepository personneRepository;

	@GetMapping(path = "/personnes", produces = { "application/xml", "application/json" })

	public List<Personne> getPersonnes() {
		return personneRepository.findAll();
	}

	@GetMapping(path = "/personnes/{id}", produces = { "application/xml", "application/json" })
	public Personne getPersonne(@PathVariable("id") int id) {
		Personne p = personneRepository.findByNum(id);
		return (p != null) ? p : null;
	}

	@PostMapping(path = "/personne", consumes = { "application/xml", "application/json" })

	public Personne addPersonne(Personne personne) {
		System.out.println(personne);
		return personneRepository.save(personne);
	}
}
