package com.choukrani.service;

import java.util.List;

import com.choukrani.model.BonLivraison;

public interface BonLivraisonService {
	
	public void ajouterBonLivraison(BonLivraison bl);
    public List<BonLivraison> listerBonLivraison();
    public void modifierBonLivraison(BonLivraison bl);
	public void supprimerBonLivraison(Long id);
	public BonLivraison recupererBonLivraison(Long id);

}
