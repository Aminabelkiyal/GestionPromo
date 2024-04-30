package com.emsi.pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsi.pfe.model.Client;
import com.emsi.pfe.repository.ClientRepository;

@Service
public class ClientService {
	 @Autowired
	    private ClientRepository clientRepository;

	    // Méthode pour récupérer tous les clients
	    public List<Client> getAllClients() {
	        return clientRepository.findAll();
	    }

	    // Méthode pour récupérer un client par ID
	    public Client getClientById(Long id) {
	        return clientRepository.findById(id).orElse(null);
	    }

	    // Méthode pour créer un client
	    public Client createClient(Client client) {
	        return clientRepository.save(client);
	    }

	    // Méthode pour mettre à jour un client
	    public Client updateClient(Long id, Client updatedClient) {
	        if (clientRepository.existsById(id)) {
	            updatedClient.setId(id);
	            return clientRepository.save(updatedClient);
	        }
	        return null;
	    }

	    // Méthode pour supprimer un client
	    public void deleteClient(Long id) {
	        clientRepository.deleteById(id);
	    }

}
