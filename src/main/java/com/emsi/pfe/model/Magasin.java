package com.emsi.pfe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Magasin {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String nom;
	 private String adresse;
	 private String geolocalisation;
	 
	 @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL)
	    private List<Coupons> coupons;
	 
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
	public List<Coupons> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<Coupons> coupons) {
		this.coupons = coupons;
	}
	
	public static Magasin fromString(String nomMagasin) {
		Magasin magasin = new Magasin ();
		magasin.setNom(nomMagasin);
		return magasin;
	}
	 
}
