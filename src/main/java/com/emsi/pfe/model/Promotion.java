package com.emsi.pfe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Promotion {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String pourcentagereduction;
	    private String description;
	    private Date datedebut;
	    private Date datefin;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPourcentagereduction() {
			return pourcentagereduction;
		}
		public void setPourcentagereduction(String pourcentagereduction) {
			this.pourcentagereduction = pourcentagereduction;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getDatedebut() {
			return datedebut;
		}
		public void setDatedebut(Date datedebut) {
			this.datedebut = datedebut;
		}
		public Date getDatefin() {
			return datefin;
		}
		public void setDatefin(Date datefin) {
			this.datefin = datefin;
		}
	    
}
