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

import com.emsi.pfe.model.Client;
import com.emsi.pfe.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	 @Autowired
	    private ClientService clientService;

	    @GetMapping
	    public List<Client> getAllClients() {
	        return clientService.getAllClients();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
	        Client client = clientService.getClientById(id);
	        if (client != null) {
	            return ResponseEntity.ok(client);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping("/clients")
	    public ResponseEntity<Client> createClient(@RequestBody Client client) {
	        Client createdClient = clientService.createClient(client);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
	    }

	    @PutMapping("/clients/{id}")
	    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
	        Client client = clientService.updateClient(id, updatedClient);
	        if (client != null) {
	            return ResponseEntity.ok(client);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/clients/{id}")
	    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
	        clientService.deleteClient(id);
	        return ResponseEntity.noContent().build();
	    }

}
