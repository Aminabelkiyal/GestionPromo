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

import com.emsi.pfe.exception.ResourceNotFoundException;
import com.emsi.pfe.model.Coupons;
import com.emsi.pfe.model.Magasin;
import com.emsi.pfe.model.Promotion;
import com.emsi.pfe.repository.CouponsRepository;
import com.emsi.pfe.service.CouponsService;
import com.emsi.pfe.service.MagasinService;

@RestController
@RequestMapping("/coupons")
public class CouponsController {
	 @Autowired
	 private CouponsService couponsService;

	 @Autowired
	    private MagasinService magasinService; // Assurez-vous d'avoir un service pour gérer Magasin

	    @PostMapping
	    public ResponseEntity<Coupons> createCoupons(@RequestBody Coupons coupons) {
	        Magasin magasin = magasinService.getMagasinById(coupons.getMagasin().getId());
	        if (magasin == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	        }
	        coupons.setMagasin(magasin);
	        Coupons createdCoupons = couponsService.createCoupons(coupons);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoupons);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Coupons> updateCoupons(@PathVariable Long id, @RequestBody Coupons updatedCoupons) {
	        Magasin magasin = magasinService.getMagasinById(updatedCoupons.getMagasin().getId());
	        if (magasin == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	        }
	        updatedCoupons.setMagasin(magasin);
	        Coupons coupons = couponsService.updateCoupons(id, updatedCoupons);
	        if (coupons != null) {
	            return ResponseEntity.ok(coupons);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCoupons(@PathVariable Long id) {
	        couponsService.deleteCoupons(id);
	        return ResponseEntity.noContent().build();
	    }
}
