package com.emsi.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.pfe.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long>{

}
