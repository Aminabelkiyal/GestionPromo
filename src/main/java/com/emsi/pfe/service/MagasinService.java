package com.emsi.pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsi.pfe.model.Magasin;
import com.emsi.pfe.repository.MagasinRepository;

@Service
public class MagasinService {
	@Autowired
	private MagasinRepository magasinRepository;
	
	public List <Magasin> getAllMagasins(){
		return magasinRepository.findAll();
	}
	
	public Magasin getMagasinById(Long id) {
		return magasinRepository.findById(id).orElseGet(null);
	}

	public Magasin createMagasin(Magasin magasin) {
		return magasinRepository.save(magasin);
	}
	
	public Magasin updateMagasin(Long id, Magasin updateMagasin) {
		if (magasinRepository.existsById(id)) {
			updateMagasin.setId(id);
			return magasinRepository.save(updateMagasin);
		}
		return null;
	}
	public void deleteMagasin(Long id) {
		magasinRepository.deleteById(id);
	}
}
