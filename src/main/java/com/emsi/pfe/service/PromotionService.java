package com.emsi.pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsi.pfe.model.Promotion;
import com.emsi.pfe.repository.PromotionRepository;

@Service
public class PromotionService {
	@Autowired
	private PromotionRepository promotionRepository;
	
	public List <Promotion> getAllPromotions(){
		return promotionRepository.findAll();
	}
	
	public Promotion getPromotionById(Long id) {
		return promotionRepository.findById(id).orElse(null);
		
	}
	public Promotion createPromotion(Promotion promotion) {
		return promotionRepository.save(promotion);
	}
	
	public Promotion updatePromotion(Long id, Promotion updatePromotion) {
		if (promotionRepository.existsById(id)) {
			updatePromotion.setId(id);
			return promotionRepository.save(updatePromotion);
		}
		return null;
	}
	
	public void deletePromotion (Long id) {
		promotionRepository.deleteById(id);
	}

}
