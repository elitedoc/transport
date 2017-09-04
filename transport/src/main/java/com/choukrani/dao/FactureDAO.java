package com.choukrani.dao;

import java.util.List;

import com.choukrani.model.Facture;

public interface FactureDAO {
	
	public void ajouterFacture(Facture fact);
    public List<Facture> listerFactures();
    public void modifierFacture(Facture fact);
	public void supprimerFacture(Long id);
	public Facture recupererFacture(Long id);

}
