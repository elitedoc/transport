package dao;

import java.util.List;

import model.Facture;

public interface FactureDAO {
	
	void save(Facture facture);
	void update(Facture facture);
	void delete(Facture facture);
	Facture findByFactureId(int factureId);
	List<Facture> getListeFacture();

}
