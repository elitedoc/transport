package service.impl;

import java.util.List;

import dao.BonLivraisonDAO;
import model.BonLivraison;
import service.BonLivraisonService;

public class BonLivraisonServiceImpl implements BonLivraisonService {
	
	BonLivraisonDAO bonLivraisonDAO;

	public void setBonLivraisonDAO(BonLivraisonDAO bonLivraisonDAO) {
		this.bonLivraisonDAO = bonLivraisonDAO;
	}

	@Override
	public void save(BonLivraison bonLivraison) {
		bonLivraisonDAO.save(bonLivraison);

	}

	@Override
	public void update(BonLivraison bonLivraison) {
		bonLivraisonDAO.update(bonLivraison);

	}

	@Override
	public void delete(BonLivraison bonLivraison) {
		bonLivraisonDAO.delete(bonLivraison);

	}

	@Override
	public BonLivraison findByBonLivraisonId(int bonLivraisonId) {
		
		return bonLivraisonDAO.findByBonLivraisonId(bonLivraisonId);
	}

	@Override
	public List<BonLivraison> getListeBonLivraison() {
		
		return bonLivraisonDAO.getListeBonLivraison();
	}

}
