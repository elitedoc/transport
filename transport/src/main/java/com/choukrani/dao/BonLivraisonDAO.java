package com.choukrani.dao;

import java.util.List;

import com.choukrani.model.BonLivraison;

public interface BonLivraisonDAO {
	
	public void ajouterBonLivraison(BonLivraison bl);
    public List<BonLivraison> listerBonLivraison();
    public void modifierBonLivraison(BonLivraison bl);
	public void supprimerBonLivraison(Long id);
	public BonLivraison recupererBonLivraison(Long id);

}
