package com.emsi.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.pfe.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
