package org.eclipse.FirstSpringMvc.controller;

import java.util.List;

import org.eclipse.FirstSpringMvc.dao.PersonneRepository;
import org.eclipse.FirstSpringMvc.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@SessionAttributes("perso")
public class ConnectionController {
	@Autowired
	private PersonneRepository personneRepository;

	@GetMapping("/connect")
	public String personneForm(Model model) {
		model.addAttribute("perso", new Personne());
		return "connectForm";
	}

	@PostMapping("/connect")
	public String checkData(@ModelAttribute("perso") Personne personne, BindingResult result, Model model,
			WebRequest request) {
		List<Personne> personnes = personneRepository.findByNomAndPrenom(personne.getNom(), personne.getPrenom());
		if (personnes.size() > 0) {
			return "redirect:personne";
		}
		return "connectForm";
	}

	@GetMapping(value = "/deconnect")
	public String leave(@ModelAttribute Personne perso, WebRequest request) {
		request.removeAttribute("perso", WebRequest.SCOPE_SESSION);
		return "redirect:connect";
	}
}
