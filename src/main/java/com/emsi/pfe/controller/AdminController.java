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

import com.emsi.pfe.model.Client;
import com.emsi.pfe.model.Magasin;
import com.emsi.pfe.model.Produit;
import com.emsi.pfe.model.Promotion;
import com.emsi.pfe.service.ClientService;
import com.emsi.pfe.service.MagasinService;
import com.emsi.pfe.service.ProduitService;
import com.emsi.pfe.service.PromotionService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	 @Autowired
	  private ClientService clientService;
	 @Autowired 
	 private MagasinService magasinService;
	 @Autowired
	 private PromotionService promotionService;
	 @Autowired
	 private ProduitService produitService;
	   

	    // Endpoint pour récupérer tous les clients
	    @GetMapping("/clients")
	    public List<Client> getAllClients() {
	        return clientService.getAllClients();
	    }

	    // Endpoint pour récupérer un client par ID
	    @GetMapping("/clients/{id}")
	    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
	        Client client = clientService.getClientById(id);
	        if (client != null) {
	            return ResponseEntity.ok(client);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Endpoint pour créer un client
	    @PostMapping("/clients")
	    public ResponseEntity<Client> createClient(@RequestBody Client client) {
	        Client createdClient = clientService.createClient(client);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
	    }

	    // Endpoint pour mettre à jour un client
	    @PutMapping("/clients/{id}")
	    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
	        Client client = clientService.updateClient(id, updatedClient);
	        if (client != null) {
	            return ResponseEntity.ok(client);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Endpoint pour supprimer un client
	    @DeleteMapping("/clients/{id}")
	    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
	        clientService.deleteClient(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
///////////////////////////////////////////////////////////	    
	    
	 // Endpoint pour récupérer tous les magasins
	    @GetMapping("/magasins")
	    public List<Magasin> getAllMagasins() {
	        return magasinService.getAllMagasins();
	    }

	    // Endpoint pour récupérer un magsin par ID
	    @GetMapping("/magasins/{id}")
	    public ResponseEntity<Magasin> getMagasinById(@PathVariable Long id) {
	        Magasin magasin = magasinService.getMagasinById(id);
	        if (magasin != null) {
	            return ResponseEntity.ok(magasin);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Endpoint pour créer un magasin
	    @PostMapping("/magasins")
	    public ResponseEntity<Magasin> createMagasin(@RequestBody Magasin magasin) {
	        Magasin createdMagasin = magasinService.createMagasin(magasin);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdMagasin);
	    }

	    // Endpoint pour mettre à jour un magasin
	    @PutMapping("/magasins/{id}")
	    public ResponseEntity<Magasin> updateMagasin(@PathVariable Long id, @RequestBody Magasin updatedMagasin) {
	    	Magasin magasin = magasinService.updateMagasin(id, updatedMagasin);
	        if (magasin != null) {
	            return ResponseEntity.ok(magasin);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Endpoint pour supprimer un magasin
	    @DeleteMapping("/magasins/{id}")
	    public ResponseEntity<Void> deleteMagasin(@PathVariable Long id) {
	        magasinService.deleteMagasin(id);
	        return ResponseEntity.noContent().build();
	    }

	    
	    
////////////////////////////////////////////////////////////  
	    
	 // Endpoint pour récupérer tous les promotions
	    @GetMapping("/promotions")
	    public List<Promotion> getAllPromotions() {
	        return promotionService.getAllPromotions();
	    }

	    // Endpoint pour récupérer une promo par ID
	    @GetMapping("/promotions/{id}")
	    public ResponseEntity<Promotion> getPromotionById(@PathVariable Long id) {
	    	Promotion promotion = promotionService.getPromotionById(id);
	        if (promotion != null) {
	            return ResponseEntity.ok(promotion);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Endpoint pour créer promo
	    @PostMapping("/promotions")
	    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
	    	Promotion createdPromotion = promotionService.createPromotion(promotion);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdPromotion);
	    }

	    // Endpoint pour mettre à jour  promo
	    @PutMapping("/promotions/{id}")
	    public ResponseEntity<Promotion> updatePromotion(@PathVariable Long id, @RequestBody Promotion updatedPromotion) {
	    	Promotion promotion = promotionService.updatePromotion(id, updatedPromotion);
	        if (promotion != null) {
	            return ResponseEntity.ok(promotion);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Endpoint pour supprimer promo
	    @DeleteMapping("/promotions/{id}")
	    public ResponseEntity<Void> deletePromotion(@PathVariable Long id) {
	        promotionService.deletePromotion(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	//////////////////////////////////////////////////////////////////////////
	    
	    
	    
	    
	    
	    // Endpoint pour récupérer tous les promotions
	    @GetMapping("/produits")
	    public List<Promotion> getAllProduits() {
	        return promotionService.getAllPromotions();
	    }

	    // Endpoint pour récupérer une promo par ID
	    @GetMapping("/produits/{id}")
	    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
	    	Produit produit = produitService.getProduitById(id);
	        if (produit != null) {
	            return ResponseEntity.ok(produit);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Endpoint pour créer promo
	    @PostMapping("/produits")
	    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
	    	Produit createdProduit = produitService.createProduit(produit);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduit);
	    }

	    // Endpoint pour mettre à jour  promo
	    @PutMapping("/produits/{id}")
	    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit updatedProduit) {
	    	Produit produit = produitService.updateProduit(id, updatedProduit);
	        if (produit != null) {
	            return ResponseEntity.ok(produit);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Endpoint pour supprimer promo
	    @DeleteMapping("/produits/{id}")
	    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
	    	produitService.deleteProduit(id);
	        return ResponseEntity.noContent().build();
	    }
	    

}
