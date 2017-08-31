package com.choukrani.service;

import java.util.List;

import com.choukrani.model.Facture;

public interface FactureService {
	
	public void ajouterFacture(Facture fact);
    public List<Facture> listerFactures();

}
