package com.emsi.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.pfe.model.Coupons;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons, Long>{

}
