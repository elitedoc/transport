package com.choukrani.ui.client;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.choukrani.service.ClientService;
import com.choukrani.model.Client;

@ManagedBean(name="clientBean")
@ViewScoped
public class ClientBean {
	
	//La liste des Blessures
	private List<Client> listeClients ;
	//Blessure DTO Objects
	private Client client ;
	//Boolean editForm Visible variable
	private boolean clientEditFormVisible = false ;
	
	@ManagedProperty(value = "#{clientService}")
	ClientService clientService;
	
	@PostConstruct
	public void init()
	{
		try{
			client = new Client() ;

		chargerClients() ; 

		RequestContext.getCurrentInstance().update("idForm:idPanelClient");
		}
		catch(Exception ex)
		{
			addMessage(FacesMessage.SEVERITY_FATAL, " proUnblème s'est produit lors du chargement des clients" );
		}
		
	 }
	
	public void enregistrerAction()
	{
		enregistrerClient();
		init() ;
	}; 
	
	public String chargerClients()
	{
		listeClients = clientService.listerClients();
		return null ;
	}
	public String enregistrerClient()
	{
		try{
		for(Client client : listeClients)
			if(client.getClient_id() == null)
				clientService.ajouterClient(client);
			else
				clientService.modifierClient(client);
		}
		catch(Exception ex)
		{
			addMessage(FacesMessage.SEVERITY_FATAL, "Un problème s'est produit lors de l'enregistrement des clients" );
		}
		return null ;
	}
	// Ajouter une blessure
	public String ajouterClientAction() {
		try{
		Client c = new Client();
		c.setIntitule(client.getIntitule());
		c.setAdresse(client.getAdresse());
		listeClients.add(c);
		client = new Client();
		}
		catch(Exception ex)
		{
			addMessage(FacesMessage.SEVERITY_FATAL, "Un problème s'est produit lors de l'ajout du client" );
		}
		return null;
	}	
	// Supprimer une blessure
		public String supprimerClientAction(Client client) { 
			try{
			listeClients.remove(client);
			if(client.getClient_id()!=null)
				clientService.supprimerClient(client.getClient_id());
			}
			catch(Exception ex)
			{
				addMessage(FacesMessage.SEVERITY_FATAL, "Un problème s'est produit lors de la suppression de la blessure" );
			}
			return null;
	}
	// Modification d'un client
		public String showClientEditFormAction(Client client) { 
			try{
			this.client = client ;
			this.clientEditFormVisible = true ;
			}
			catch(Exception ex)
			{
				addMessage(FacesMessage.SEVERITY_FATAL, "Un problème s'est produit lors de l'affichage du client" );
			}
			return null;
	}
	public String updateClientAction() 
	{ 
		try{
		this.clientEditFormVisible = false ;
		client = new Client() ;
		}
		catch(Exception ex)
		{
			addMessage(FacesMessage.SEVERITY_FATAL, "Un problème s'est produit lors de la modification du client" );
		}
		return null;
	}
	// Cancel action
		public String clientCancel() {
		this.clientEditFormVisible = false ;
		client = new Client(); 
		return null;
	}
		
		public List<Client> getListeClients() {
			return listeClients;
		}

		public void setListeClients(List<Client> listeClients) {
			this.listeClients = listeClients;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public boolean isClientEditFormVisible() {
			return clientEditFormVisible;
		}

		public void setClientEditFormVisible(boolean clientEditFormVisible) {
			this.clientEditFormVisible = clientEditFormVisible;
		}

		public ClientService getClientService() {
			return clientService;
		}

		public void setClientService(ClientService clientService) {
			this.clientService = clientService;
		}

		private void addMessage(Severity severity, String summary) {
			FacesMessage message = new FacesMessage(severity, summary, null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
}
