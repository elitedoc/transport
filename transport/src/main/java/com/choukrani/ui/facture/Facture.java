package com.choukrani.ui.facture;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.choukrani.service.ClientServiceImpl;
import com.choukrani.service.FactureServiceImpl;

@ManagedBean
@ViewScoped
public class Facture {

	private Helper helper;
	
	@ManagedProperty(value="#{FactureServiceImpl}")
	private FactureServiceImpl factureServiceImpl; 
	
	@ManagedProperty(value="#{ClientServiceImpl}")
	private ClientServiceImpl clientServiceImpl;
	
	/**
	 * Constantes
	 ************************************************************************************/
	private static final long serialVersionUID = 1L;
	//Messages
	private final static String ADD_SUCCESS = "Facture ajoutée avec succès";
	private final static String ADD_ERROR = "Erreur, Facture non ajoutée";
	private final static String DELETE_SUCCESS = "Facture supprimée avec succès";
	private final static String DELETE_ERROR = "Erreur, Facture non supprimée";
	private final static String UPDATE_SUCCESS = "Facture modifiée avec succès";
	private final static String UPDATE_ERROR = "Erreur, Facture non modifée";

	/**
	 * Getters/Setters
	 ************************************************************************************/
	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	
	public FactureServiceImpl getFactureServiceImpl() {
		return factureServiceImpl;
	}

	public void setFactureServiceImpl(FactureServiceImpl factureServiceImpl) {
		this.factureServiceImpl = factureServiceImpl;
	}

	public ClientServiceImpl getClientServiceImpl() {
		return clientServiceImpl;
	}

	public void setClientServiceImpl(ClientServiceImpl clientServiceImpl) {
		this.clientServiceImpl = clientServiceImpl;
	}

	/**
	 * Constructeur
	 ************************************************************************************/

	public Facture() {
		helper = new Helper();
	}

	/**
	 * Méthodes 
	 ************************************************************************************/
	
	// Chargement des données
	@PostConstruct
	public void init() {
		this.getHelper().setListe(factureServiceImpl.listerFactures());
		this.getHelper().setListeClients(clientServiceImpl.listerClients());
	}
	
		
	// Affichage des attributs de l'enregistrement à modifier
	public void fetchToUpdate() {
		this.helper.setFacture(this.getFactureServiceImpl()
				.recupererFacture(this.getHelper().getSelectedId()));
		if(this.helper.getFacture().getClient()==null)
			this.helper.setSelectedIdC(null);
		else
			this.helper.setSelectedIdC(this.getHelper().getFacture().getClient().getClient_id());
	}

	// Suppression
	public void delete() {
		try {
			//Supprimer
			this.getFactureServiceImpl()
					.supprimerFacture(this.getHelper().getSelectedId());
			//Recharger les données
			init();
			//Afficher le message de succès
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							DELETE_SUCCESS, DELETE_SUCCESS));
		} catch (Exception e) {
			e.printStackTrace();
			//Afficher le message d'erreur
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, DELETE_ERROR,
							DELETE_ERROR));
		}
	}

	// Création
	public void add() {
		try {
			//Si Aucun plan d'action n'est selectionné
			if(this.helper.getSelectedIdC()==0 )
				this.getHelper().getFacture().setClient(null);
			//Sinon
			else
				this.getHelper().getFacture().setClient(this.getClientServiceImpl().recupererClient(this.getHelper().getSelectedIdC()));
			//Ajouter
			this.getFactureServiceImpl()
					.ajouterFacture(this.helper.getFacture());
			//Recharger les données
			init();
			//Afficher le message de succès
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, ADD_SUCCESS,
							ADD_SUCCESS));
			//Fermer la boite de dialogue
			RequestContext.getCurrentInstance().execute("ajout.hide()");
		} catch (Exception e) {
			//Afficher le message d'erreur
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, ADD_ERROR,
							ADD_ERROR));
		}
	}
	
	//Modifier
	public void update() {
		try {
			//Si Aucun plan d'action n'est selectionné
			if(this.helper.getSelectedIdC()==0 )
				this.getHelper().getFacture().setClient(null);
			//Sinon
			else
				this.getHelper().getFacture().setClient(this.getClientServiceImpl().recupererClient(this.getHelper().getSelectedIdC()));
			//Modifier
			this.getFactureServiceImpl()
					.modifierFacture(this.helper.getFacture());
			//Recharger les données
			init();
			//Afficher le message de succès
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							UPDATE_SUCCESS, UPDATE_SUCCESS));
			//Fermer la boite de dialogue
			RequestContext.getCurrentInstance().execute("modification.hide()");
		} catch (Exception e) {
			//Afficher le message d'erreur
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, UPDATE_ERROR,
							UPDATE_ERROR));
		}
	}

	public void annuler() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("action.xhtml");
	}

}
