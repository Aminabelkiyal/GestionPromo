package com.emsi.pfe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Magasin {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String nom;
	 private String adresse;
	 private String geolocalisation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getGeolocalisation() {
		return geolocalisation;
	}
	public void setGeolocalisation(String geolocalisation) {
		this.geolocalisation = geolocalisation;
	}
	 
}
