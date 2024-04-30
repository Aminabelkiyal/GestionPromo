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

import com.emsi.pfe.model.Magasin;
import com.emsi.pfe.service.MagasinService;

@RestController
@RequestMapping("/magasins")
public class MagasinController {
	
	@Autowired
	private MagasinService magasinService;
	
	@GetMapping
	public List<Magasin>getAllMagasins(){
		return magasinService.getAllMagasins();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Magasin> getMagasinById(@PathVariable Long id){
		Magasin magasin = magasinService.getMagasinById(id);
		if (magasin != null) {
			return ResponseEntity.ok(magasin);
		}else {
			return ResponseEntity.notFound().build();
		}
	
}
	@PostMapping("/magasins")
	public ResponseEntity<Magasin> createMagasin(@RequestBody Magasin magasin){
		Magasin createdMagasin = magasinService.createMagasin(magasin);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdMagasin);
	}
	
	@PutMapping("/magasins/{id}")
	public ResponseEntity<Magasin> updateMagasin(@PathVariable Long id,@RequestBody Magasin updateMagasin){
		Magasin magasin = magasinService.updateMagasin(id, updateMagasin);
		if ( magasin != null) {
			return ResponseEntity.ok(magasin);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/magasins/{id}")
	public ResponseEntity<Void> deleteMagasin(@PathVariable Long id){
		magasinService.deleteMagasin(id);
		return ResponseEntity.noContent().build();
	}
}