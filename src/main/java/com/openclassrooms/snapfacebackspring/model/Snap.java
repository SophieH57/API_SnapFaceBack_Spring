package com.openclassrooms.snapfacebackspring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity //Tell hibernate to make a table out of this class
@Table(name="snap")

public class Snap {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_snap;
	
	private String title;
	
	private String imageUrl;
	private Date createdDate;
	private String location;
	
	private String utilisateur;

	
	public Long getId_snap() {
		return id_snap;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
}
