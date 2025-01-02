package tn.itbs.authentification.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import tn.itbs.authentification.entities.Utilisateur;
import tn.itbs.authentification.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;
	
	@Transactional
	public ResponseEntity<Object> addUtilisateur(Utilisateur user) {

		utilisateurRepo
		    .findById(user.getId())
		    .ifPresentOrElse(
		    	u -> {
		    		System.out.println("present");
		    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur already exit") ;
		    	} ,
		    	() -> {
		    		utilisateurRepo.save(user);
		    		}
		    	);
		return ResponseEntity.ok().body("Ajout avec succès");
	}
	
	@Transactional
	public Optional<Utilisateur> findOneUtilisateur(int id) {
		return utilisateurRepo.findById(id);
	}
}
