package com.choukrani.service;

import java.util.List;

import com.choukrani.model.Client;

public interface ClientService {
	
	public void ajouterClient(Client cl);
    public List<Client> listerClients();

}
