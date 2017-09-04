package com.choukrani.ui.facture;

import java.util.ArrayList;
import java.util.List;

import com.choukrani.model.Client;
import com.choukrani.model.Facture;

public class Helper {
	
	private Facture facture;
	private List<Facture> liste = new ArrayList<Facture>();
	private List<Client> listeClients = new ArrayList<Client>();
	private Long selectedId;
	private Long selectedIdC;
	
	public Helper() {
		facture = new Facture();
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public List<Facture> getListe() {
		return liste;
	}

	public void setListe(List<Facture> liste) {
		this.liste = liste;
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

}
