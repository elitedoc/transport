package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity  
@Table(name= "bon_livraison")
public class BonLivraison {
	
	@Id
	private int bon_livraison_id;
	private int numero_bon_livraison;
	private Date date_bon_livraison;
	private String depart;
	private String destination;
	private float quantite;
	private float tarif;
	private float prix_unitaire;
	private float montant_ht;
	private Client client;
	private Facture facture;
	public int getBon_livraison_id() {
		return bon_livraison_id;
	}
	public void setBon_livraison_id(int bon_livraison_id) {
		this.bon_livraison_id = bon_livraison_id;
	}
	public int getNumero_bon_livraison() {
		return numero_bon_livraison;
	}
	public void setNumero_bon_livraison(int numero_bon_livraison) {
		this.numero_bon_livraison = numero_bon_livraison;
	}
	public Date getDate_bon_livraison() {
		return date_bon_livraison;
	}
	public void setDate_bon_livraison(Date date_bon_livraison) {
		this.date_bon_livraison = date_bon_livraison;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public float getQuantite() {
		return quantite;
	}
	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}
	public float getTarif() {
		return tarif;
	}
	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
	public float getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(float prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
	public float getMontant_ht() {
		return montant_ht;
	}
	public void setMontant_ht(float montant_ht) {
		this.montant_ht = montant_ht;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	

}
