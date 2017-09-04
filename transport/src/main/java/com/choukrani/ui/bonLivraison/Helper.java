package com.choukrani.ui.bonLivraison;

import java.util.ArrayList;
import java.util.List;

import com.choukrani.model.BonLivraison;
import com.choukrani.model.Client;
import com.choukrani.model.Facture;

public class Helper {
	
	private BonLivraison bonLivraison;
	private List<BonLivraison> liste = new ArrayList<BonLivraison>();
	private List<Facture> listeFactures = new ArrayList<Facture>();
	private List<Client> listeClients = new ArrayList<Client>();
	private Long selectedId;
	private Long selectedIdC;
	private Long selectedIdF;
	
	public Helper() {
		bonLivraison = new BonLivraison();
	}

	public BonLivraison getBonLivraison() {
		return bonLivraison;
	}

	public void setBonLivraison(BonLivraison bonLivraison) {
		this.bonLivraison = bonLivraison;
	}

	public List<BonLivraison> getListe() {
		return liste;
	}

	public void setListe(List<BonLivraison> liste) {
		this.liste = liste;
	}

	public List<Facture> getListeFactures() {
		return listeFactures;
	}

	public void setListeFactures(List<Facture> listeFactures) {
		this.listeFactures = listeFactures;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public Long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}

	public Long getSelectedIdC() {
		return selectedIdC;
	}

	public void setSelectedIdC(Long selectedIdC) {
		this.selectedIdC = selectedIdC;
	}

	public Long getSelectedIdF() {
		return selectedIdF;
	}

	public void setSelectedIdF(Long selectedIdF) {
		this.selectedIdF = selectedIdF;
	}

}
