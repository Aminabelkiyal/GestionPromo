package com.emsi.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.pfe.model.Magasin;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin, Long>{

}
