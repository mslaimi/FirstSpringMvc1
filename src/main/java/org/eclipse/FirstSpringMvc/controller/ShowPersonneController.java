package org.eclipse.FirstSpringMvc.controller;

import java.util.ArrayList;

import org.eclipse.FirstSpringMvc.model.Personne;
import org.eclipse.FirstSpringMvc.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShowPersonneController {
	@Autowired
	private PersonneService personneService;
	@GetMapping("/showPers/{nom}")
	public String showPersonne(@PathVariable String nom, Model
	model) {
	Personne personne = personneService.getPersonne(nom);
	model.addAttribute("personne", personne);
	return "jsp/showPersonne";
	}
	
	@GetMapping("/showPersonnes")
	public String showPersonnes(Model model) {
		ArrayList<Personne> personnes = (ArrayList<Personne>) personneService.findAll();
		model.addAttribute("personnes", personnes);
		return "jsp/showPersonnes";
	}

	@GetMapping("/showPersonne/{num}")
	public String showPersonne(Model model, @PathVariable long num) {
		Personne personne = personneService.findById(num);
		model.addAttribute("personne", personne);
		return "jsp/showPersonne";
	}
}
