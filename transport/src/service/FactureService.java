package service;

import java.util.List;

import model.Facture;

public interface FactureService {
	
	void save(Facture facture);
	void update(Facture facture);
	void delete(Facture facture);
	Facture findByFactureId(int factureId);
	List<Facture> getListeFacture();

}
