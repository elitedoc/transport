package com.choukrani.ui.client;

import java.util.ArrayList;
import java.util.List;

import com.choukrani.model.Client;

public class Helper {
	
	private Client client;
	private List<Client> liste = new ArrayList<Client>();
	private List<Client> filtered;
	private Long selectedId;
	
	public Helper() {
		client = new Client();
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Client> getListe() {
		return liste;
	}
	public void setListe(List<Client> liste) {
		this.liste = liste;
	}
	public List<Client> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<Client> filtered) {
		this.filtered = filtered;
	}

	public Long getSelectedId() {
		return selectedId;
	}
	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}

}
