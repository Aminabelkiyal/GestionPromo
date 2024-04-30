package com.emsi.pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsi.pfe.model.Produit;
import com.emsi.pfe.repository.ProduitRepository;


@Service
public class ProduitService {
	@Autowired
	private ProduitRepository produitRepository;
	
	public List <Produit> getAllProduits(){
		return produitRepository.findAll();
	}
	
	public Produit getProduitById(Long id) {
		return produitRepository.findById(id).orElse(null);
		
	}
	public Produit createProduit(Produit produit) {
		return produitRepository.save(produit);
	}
	
	public Produit updateProduit(Long id, Produit updateProduit) {
		if (produitRepository.existsById(id)) {
			updateProduit.setId(id);
			return produitRepository.save(updateProduit);
		}
		return null;
	}
	
	public void deleteProduit (Long id) {
		produitRepository.deleteById(id);
	}

}
