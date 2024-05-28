package com.emsi.pfe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Coupons {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String code;
	    
	    private double montantpromo;
	    
	    // Relation ManyToOne avec la classe Magasin
	    @ManyToOne
	    @JoinColumn(name = "magasin_id", referencedColumnName = "id")
	    private Magasin magasin;

	    
	    public Coupons() {
	        // Constructeur par défaut
	    }

	    public Coupons(String code, double montantpromo, Magasin magasin) {
	        this.code = code;
	        this.montantpromo = montantpromo;
	        this.magasin = magasin;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public double getMontantpromo() {
			return montantpromo;
		}

		public void setMontantpromo(double montantpromo) {
			this.montantpromo = montantpromo;
		}

		public Magasin getMagasin() {
			return magasin;
		}

		public void setMagasin(Magasin magasin) {
			this.magasin = magasin;
		}
	    
	    
	    
	    
	    
}
