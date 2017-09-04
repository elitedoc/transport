package com.choukrani.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity  
@Table(name= "FACTURE")
@ManagedBean(name="facture")
public class Facture {

	@Id
	@Column(name="facture_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long facture_id;
	
	private Long numero_facture;
	
	private Date date_facture;
	
	private String commentaire;
	
	private float total_htva;
	
	private float tva;
	
	private float total_tvac;
	
	@ManyToOne
	@JoinColumn(name="fk_id_client")
	private Client client;
	
	@OneToMany(mappedBy="facture")
	private List<BonLivraison> listeBonsLivraison = new ArrayList<BonLivraison>();
	
	public Long getFacture_id() {
		return facture_id;
	}
	
	public void setFacture_id(Long facture_id) {
		this.facture_id = facture_id;
	}
	
	public Long getNumero_facture() {
		return numero_facture;
	}
	
	public void setNumero_facture(Long numero_facture) {
		this.numero_facture = numero_facture;
	}
	
	public Date getDate_facture() {
		return date_facture;
	}
	
	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public float getTotal_htva() {
		return total_htva;
	}
	
	public void setTotal_htva(float total_htva) {
		this.total_htva = total_htva;
	}
	
	public float getTva() {
		return tva;
	}
	
	public void setTva(float tva) {
		this.tva = tva;
	}
	
	public float getTotal_tvac() {
		return total_tvac;
	}
	
	public void setTotal_tvac(float total_tvac) {
		this.total_tvac = total_tvac;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public List<BonLivraison> getListeBonsLivraison() {
		return listeBonsLivraison;
	}

	public void setListeBonsLivraison(List<BonLivraison> listeBonsLivraison) {
		this.listeBonsLivraison = listeBonsLivraison;
	}

	@Override
	public String toString() {
		return "Facture [facture_id=" + facture_id + ", numero_facture=" + numero_facture + ", date_facture="
				+ date_facture + ", commentaire=" + commentaire + ", total_htva=" + total_htva + ", tva=" + tva
				+ ", total_tvac=" + total_tvac + ", client=" + client + "]";
	}
}
