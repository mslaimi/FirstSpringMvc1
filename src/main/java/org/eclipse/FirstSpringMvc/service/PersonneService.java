package org.eclipse.FirstSpringMvc.service;

import java.util.List;

import org.eclipse.FirstSpringMvc.dao.PersonneRepository;
import org.eclipse.FirstSpringMvc.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {
	@Autowired
	private PersonneRepository personneRepository;

	@PreAuthorize("hasRole('ROLE_USER') and hasRole('ROLE_ADMIN')")
	public List<Personne> findAll() {
		return personneRepository.findAll();
	}

	@Secured("ROLE_USER")
	public Personne findById(Long id) {
		return personneRepository.findById(id).orElse(null);
	}

	@PostAuthorize("returnObject.nom == authentication.principal.username")
			public Personne getPersonne(String username) {
			Personne personne= personneRepository.findByNom(username);
			if (personne == null)
			personne = new Personne();
			return personne;
			}
}
