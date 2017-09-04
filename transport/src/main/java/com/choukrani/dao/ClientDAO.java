package com.choukrani.dao;

import java.util.List;

import com.choukrani.model.Client;

public interface ClientDAO {
	
	public void ajouterClient(Client cl);
    public List<Client> listerClients();
    public void modifierClient(Client cl);
	public void supprimerClient(Long id);
	public Client recupererClient(Long id);

}
