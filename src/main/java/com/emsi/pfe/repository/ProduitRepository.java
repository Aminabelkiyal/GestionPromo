package com.emsi.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.pfe.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
