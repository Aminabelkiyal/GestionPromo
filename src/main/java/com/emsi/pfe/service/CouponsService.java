package com.emsi.pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsi.pfe.model.Coupons;
import com.emsi.pfe.repository.CouponsRepository;

@Service
public class CouponsService {

	@Autowired
	private CouponsRepository couponsRepository;
	
	public List <Coupons> getAllCoupons(){
		return couponsRepository.findAll();
	}
	
	public Coupons getCouponsById(Long id) {
		return couponsRepository.findById(id).orElse(null);
		
	}
	public Coupons createCoupons(Coupons coupons) {
		return couponsRepository.save(coupons);
	}
	
	public Coupons updateCoupons(Long id, Coupons updateCoupons) {
		if (couponsRepository.existsById(id)) {
			updateCoupons.setId(id);
			return couponsRepository.save(updateCoupons);
		}
		return null;
	}
	
	public void deleteCoupons (Long id) {
		couponsRepository.deleteById(id);
	}

}
