package com.choukrani.ui.bonLivraison;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.choukrani.service.BonLivraisonServiceImpl;
import com.choukrani.service.ClientServiceImpl;
import com.choukrani.service.FactureServiceImpl;

@ManagedBean
@ViewScoped
public class BonLivraison {

	private Helper helper;

	@ManagedProperty(value = "#{BonLivraisonServiceImpl}")
	private BonLivraisonServiceImpl bonLivraisonServiceImpl;

	@ManagedProperty(value = "#{FactureServiceImpl}")
	private FactureServiceImpl factureServiceImpl;

	@ManagedProperty(value = "#{ClientServiceImpl}")
	private ClientServiceImpl clientServiceImpl;
	
	/**
	 * Constantes
	 ************************************************************************************/
	//Messages
	private final static String ADD_SUCCESS = "Bon de livraison ajouté avec succès";
	private final static String ADD_ERROR = "Erreur, Bon de livraison non ajouté";
	private final static String DELETE_SUCCESS = "Bon de livraison supprimé avec succès";
	private final static String DELETE_ERROR = "Erreur, Bon de livraison non supprimé";
	private final static String UPDATE_SUCCESS = "Bon de livraison modifié avec succès";
	private final static String UPDATE_ERROR = "Erreur, Bon de livraison non modifé";

	/**
	 * Getters/Setters
	 ************************************************************************************/
	public Helper getHelper() {
		return helper;
	}

	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	
	public BonLivraisonServiceImpl getBonLivraisonServiceImpl() {
		return bonLivraisonServiceImpl;
	}

	public void setBonLivraisonServiceImpl(BonLivraisonServiceImpl bonLivraisonServiceImpl) {
		this.bonLivraisonServiceImpl = bonLivraisonServiceImpl;
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

	public BonLivraison() {
		helper = new Helper();
	}

	/**
	 * Méthodes 
	 ************************************************************************************/
	
	// Chargement des données
	@PostConstruct
	public void init() {
		this.getHelper().setListe(bonLivraisonServiceImpl.listerBonLivraison());
		this.getHelper().setListeFactures(factureServiceImpl.listerFactures());
		this.getHelper().setListeClients(clientServiceImpl.listerClients());
	}
	
		
	// Affichage des attributs de l'enregistrement à modifier
	public void fetchToUpdate() {
		this.helper.setBonLivraison(this.getBonLivraisonServiceImpl()
				.recupererBonLivraison(this.getHelper().getSelectedId()));
		if(this.helper.getBonLivraison().getClient()==null)
			this.helper.setSelectedIdC(null);
		else
			this.helper.setSelectedIdC(this.getHelper().getBonLivraison().getClient().getClient_id());
		if(this.helper.getBonLivraison().getFacture()==null)
			this.helper.setSelectedIdF(null);
		else
			this.helper.setSelectedIdF(this.getHelper().getBonLivraison().getFacture().getFacture_id());
	}

	// Suppression
	public void delete() {
		try {
			//Supprimer
			this.getBonLivraisonServiceImpl()
					.supprimerBonLivraison(this.getHelper().getSelectedId());
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
				this.getHelper().getBonLivraison().setClient(null);
			//Sinon
			else
				this.getHelper().getBonLivraison().setClient(this.getClientServiceImpl().recupererClient(this.getHelper().getSelectedIdC()));
			//Si Aucun plan d'action n'est selectionné
			if(this.helper.getSelectedIdF()==0 )
				this.getHelper().getBonLivraison().setFacture(null);
			//Sinon
			else
				this.getHelper().getBonLivraison().setFacture(this.getFactureServiceImpl().recupererFacture(this.getHelper().getSelectedIdF()));
			//Ajouter
			this.getBonLivraisonServiceImpl()
					.ajouterBonLivraison(this.helper.getBonLivraison());
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
				this.getHelper().getBonLivraison().setClient(null);
			//Sinon
			else
				this.getHelper().getBonLivraison().setClient(this.getClientServiceImpl().recupererClient(this.getHelper().getSelectedIdC()));
			//Si Aucun plan d'action n'est selectionné
			if(this.helper.getSelectedIdF()==0 )
				this.getHelper().getBonLivraison().setFacture(null);
			//Sinon
			else
				this.getHelper().getBonLivraison().setFacture(this.getFactureServiceImpl().recupererFacture(this.getHelper().getSelectedIdF()));
			//Modifier
			this.getBonLivraisonServiceImpl()
					.modifierBonLivraison(this.helper.getBonLivraison());
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
