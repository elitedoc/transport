package service.impl;

import java.util.List;

import dao.FactureDAO;
import model.Facture;
import service.FactureService;

public class FactureServiceImpl implements FactureService {
	
	FactureDAO factureDAO;
	
	

	public void setFactureDAO(FactureDAO factureDAO) {
		this.factureDAO = factureDAO;
	}

	@Override
	public void save(Facture facture) {
		factureDAO.save(facture);

	}

	@Override
	public void update(Facture facture) {
		factureDAO.update(facture);

	}

	@Override
	public void delete(Facture facture) {
		factureDAO.delete(facture);

	}

	@Override
	public Facture findByFactureId(int factureId) {
		
		return factureDAO.findByFactureId(factureId);
	}

	@Override
	public List<Facture> getListeFacture() {
		
		return factureDAO.getListeFacture();
	}

}
