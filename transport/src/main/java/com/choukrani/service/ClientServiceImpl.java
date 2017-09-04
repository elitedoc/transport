package com.choukrani.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choukrani.dao.ClientDAO;
import com.choukrani.model.Client;

@Service
public class ClientServiceImpl implements ClientService {
	
	ClientDAO clientDAO;

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	@Transactional
	public void ajouterClient(Client cl) {
		this.clientDAO.ajouterClient(cl);
		
	}

	@Override
	@Transactional
	public List<Client> listerClients() {
		return this.clientDAO.listerClients();
	}

	@Override
	@Transactional
	public void modifierClient(Client cl) {
		this.clientDAO.modifierClient(cl);
		
	}

	@Override
	@Transactional
	public void supprimerClient(Long id) {
		this.clientDAO.supprimerClient(id);
		
	}

	@Override
	@Transactional
	public Client recupererClient(Long id) {
		return this.clientDAO.recupererClient(id);
	}

	

}
