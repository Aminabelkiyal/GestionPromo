package com.emsi.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.pfe.model.Produit;
import com.emsi.pfe.service.ProduitService;

@RestController
@RequestMapping("/produits")
public class ProduitController {
	@Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
    	Produit produit = produitService.getProduitById(id);
        if (produit != null) {
            return ResponseEntity.ok(produit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/produits")
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
    	Produit createdProduit = produitService.createProduit(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduit);
    }

    @PutMapping("/produits/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit updatedProduit) {
    	Produit produit = produitService.updateProduit(id, updatedProduit);
        if (produit != null) {
            return ResponseEntity.ok(produit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/produits/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
    	produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }


}
