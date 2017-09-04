package com.choukrani.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name= "CLIENT")
@ManagedBean(name="client")
public class Client {
	
	@Id
	@Column(name="client_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long client_id;
	
	private String intitule;
	
	private String adresse;
	
	@OneToMany(mappedBy="client")
	private List<Facture> listeFactures = new ArrayList<Facture>();
	
	@OneToMany(mappedBy="client")
	private List<BonLivraison> listeBonsLivraison = new ArrayList<BonLivraison>();
	
	public Long getClient_id() {
		return client_id;
	}
	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", intitule=" + intitule + ", adresse=" + adresse + "]";
	}

}
