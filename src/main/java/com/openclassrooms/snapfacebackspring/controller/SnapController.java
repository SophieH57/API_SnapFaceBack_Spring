package com.openclassrooms.snapfacebackspring.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.snapfacebackspring.model.Snap;
import com.openclassrooms.snapfacebackspring.service.SnapService;

@RestController
@RequestMapping(path="")
public class SnapController {

	@Autowired
	private SnapService snapService;
	
	//Création nouveau Snap
	@PostMapping("/addfacesnap")
	public Snap createSnap(@RequestBody Snap newSnap) {
		return snapService.saveSnap(newSnap);
	}
	
	//Afficher un snap récupéré par son id
	@GetMapping("/facesnaps/{idSnap}")
	public Snap getSnap(@PathVariable("idSnap") final Long idSnap) {
		Optional<Snap> snap = snapService.getSnap(idSnap);
		if (snap.isPresent()) {
			return snap.get();
		} else {
			return null;
		}
	}
	
	//Afficher tous les snaps
	@GetMapping("/facesnaps")
	public Iterable<Snap> getSnaps(){
		return snapService.getSnaps();
	}
	
	//Modifier un snap
	@PutMapping("/facesnaps/{idSnap}")
	public Snap updateSnap(@PathVariable("idSnap") final Long idSnap, @RequestBody Snap snap) {
		Optional<Snap> s = snapService.getSnap(idSnap);
		if (s.isPresent()) {
			Snap currentSnap = s.get();
			
			String title = snap.getTitle();
			if(title != null) {
				currentSnap.setTitle(title);
			}
			
			String imageUrl = snap.getImageUrl();
			if(imageUrl!=null) {
				currentSnap.setImageUrl(imageUrl);
			}
			
			Date createdDate = snap.getCreatedDate();
			if(createdDate!=null) {
				currentSnap.setCreatedDate(createdDate);
			}
			
			String location = snap.getLocation();
			if (location!=null) {
				currentSnap.setLocation(location);
			}
			
			String utilisateur = snap.getUtilisateur();
			if(utilisateur!=null) {
				currentSnap.setUtilisateur(utilisateur);
			}
			
			snapService.saveSnap(currentSnap);
			return currentSnap;
		} else {
			return null;
		}
	}
		
	//Supprimer un snap
		@DeleteMapping("/facesnaps/{idSnap}")
		public void deleteSnap(@PathVariable("idSnap") final Long idSnap) {
			snapService.deleteSnap(idSnap);	
	}
}
