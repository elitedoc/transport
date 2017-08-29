package dao;

import java.util.List;

import model.BonLivraison;

public interface BonLivraisonDAO {
	
	void save(BonLivraison bonLivraison);
	void update(BonLivraison bonLivraison);
	void delete(BonLivraison bonLivraison);
	BonLivraison findByBonLivraisonId(int bonLivraisonId);
	List<BonLivraison> getListeBonLivraison();

}
