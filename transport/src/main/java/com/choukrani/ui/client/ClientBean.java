package com.choukrani.ui.client;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.choukrani.service.ClientService;

@ManagedBean
@ViewScoped
public class ClientBean {

	private Helper helper;

	@ManagedProperty(value = "#{ClientService}")
	private ClientService clientService;

	private final static String ADD_SUCCESS = "Client ajouté avec succès";
	private final static String ADD_ERROR = "Erreur, Client non ajouté";
	private final static String DELETE_SUCCESS = "Client supprimé avec succès";
	private final static String DELETE_ERROR = "Erreur, Client non supprimé";
	private final static String UPDATE_SUCCESS = "Client modifié avec succès";
	private final static String UPDATE_ERROR = "Erreur, Client non modifé";

	public ClientBean() {
		helper = new Helper();
	}

	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	// Chargement des données
	@PostConstruct
	public void init() {
		this.getHelper().setListe(clientService.listerClients());
	}

	public void fetchToUpdate() {
		this.helper.setClient(this.getClientService().recupererClient(this.getHelper().getSelectedId()));
	}

	// Suppression
	public void delete() {
		try {
			// Supprimer
			this.getClientService().supprimerClient(this.getHelper().getSelectedId());
			// Recharger les données
			init();
			// Afficher le message de succès
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, DELETE_SUCCESS, DELETE_SUCCESS));
		} catch (Exception e) {
			e.printStackTrace();
			// Afficher le message d'erreur
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, DELETE_ERROR, DELETE_ERROR));
		}
	}

	// Création
	public void add() {
		try {
			// Ajouter
			this.getClientService().ajouterClient(this.helper.getClient());
			// Recharger les données
			init();
			// Afficher le message de succès
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, ADD_SUCCESS, ADD_SUCCESS));
			// Fermer la boite de dialogue
			RequestContext.getCurrentInstance().execute("ajout.hide()");
		} catch (Exception e) {
			// Afficher le message d'erreur
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, ADD_ERROR, ADD_ERROR));
		}
	}

	// Modifier
	public void update() {
		try {
			// Modifier
			this.getClientService().modifierClient(this.helper.getClient());
			// Recharger les données
			init();
			// Afficher le message de succès
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, UPDATE_SUCCESS, UPDATE_SUCCESS));
			// Fermer la boite de dialogue
			RequestContext.getCurrentInstance().execute("modification.hide()");
		} catch (Exception e) {
			// Afficher le message d'erreur
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, UPDATE_ERROR, UPDATE_ERROR));
		}
	}

	public void annuler() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("client.xhtml");
	}

}
