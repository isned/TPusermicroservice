package tn.itbs.authentification.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tn.itbs.authentification.entities.Utilisateur;
import tn.itbs.authentification.services.UtilisateurService;

@RefreshScope
@RestController
@RequestMapping("/user")
public class UtilisateurREST {



	@Autowired
	private UtilisateurService utilisateurService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> createUtilisateur(@RequestBody Utilisateur user) {
	    return utilisateurService.addUtilisateur(user);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Utilisateur> findUtilisateur(@PathVariable int id) {
		return utilisateurService.findOneUtilisateur(id);
	}
	
	
	
	
}
