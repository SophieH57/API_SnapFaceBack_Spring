package com.openclassrooms.snapfacebackspring.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin
	@PostMapping("/addfacesnap")
	public Snap createSnap(@RequestBody Snap newSnap) {
		return snapService.saveSnap(newSnap);
	}
	
	//Afficher un snap récupéré par son id
	@CrossOrigin
	@GetMapping("/facesnaps/{id_snap}")
	public Snap getSnap(@PathVariable("id_snap") final Long id_snap) {
		Optional<Snap> snap = snapService.getSnap(id_snap);
		if (snap.isPresent()) {
			return snap.get();
		} else {
			return null;
		}
	}
	
	//Afficher tous les snaps
	@CrossOrigin
	@GetMapping("/facesnaps")
	public Iterable<Snap> getSnaps(){
		return snapService.getSnaps();
	}
	
	//Modifier un snap
	@CrossOrigin
	@PutMapping("/facesnaps/{id_snap}")
	public Snap updateSnap(@PathVariable("id_snap") final Long id_snap, @RequestBody Snap snap) {
		Optional<Snap> s = snapService.getSnap(id_snap);
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
	@CrossOrigin
		@DeleteMapping("/facesnaps/{id_snap}")
		public void deleteSnap(@PathVariable("id_snap") final Long id_snap) {
			snapService.deleteSnap(id_snap);	
	}
}
