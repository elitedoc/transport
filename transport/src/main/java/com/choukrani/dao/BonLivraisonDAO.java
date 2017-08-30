package com.choukrani.dao;

import java.util.List;

import com.choukrani.model.BonLivraison;

public interface BonLivraisonDAO {
	
	public void ajouterBonLivraison(BonLivraison bl);
    public List<BonLivraison> listerBonLivraison();

}
