package com.openclassrooms.snapfacebackspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.snapfacebackspring.model.Snap;
import com.openclassrooms.snapfacebackspring.repository.SnapRepository;

import lombok.Data;

@Data
@Service
public class SnapService {

	@Autowired
	private SnapRepository snapRepository;
	
	public Optional<Snap> getSnap(final Long id_snap){
		return snapRepository.findById(id_snap);
	}
	
	public Iterable<Snap> getSnaps(){
		return snapRepository.findAll();
	}
	
	public void deleteSnap(final Long id_snap) {
		snapRepository.deleteById(id_snap);
	}
	
	public Snap saveSnap(Snap newSnap) {
		Snap savedSnap = snapRepository.save(newSnap);
		return savedSnap;
	}
}
