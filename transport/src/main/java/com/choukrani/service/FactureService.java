package com.choukrani.service;

import java.util.List;

import com.choukrani.model.Facture;

public interface FactureService {
	
	void save(Facture facture);
	void update(Facture facture);
	void delete(Facture facture);
	Facture findByFactureId(int factureId);
	List<Facture> getListeFacture();

}
