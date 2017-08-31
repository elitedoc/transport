package com.choukrani.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choukrani.dao.BonLivraisonDAO;
import com.choukrani.model.BonLivraison;

@Service
@ManagedBean(name="bonLivraisonService")
@SessionScoped
public class BonLivraisonServiceImpl implements BonLivraisonService {
	
	BonLivraisonDAO bonLivraisonDAO;

	public void setBonLivraisonDAO(BonLivraisonDAO bonLivraisonDAO) {
		this.bonLivraisonDAO = bonLivraisonDAO;
	}

	@Override
	@Transactional
	public void ajouterBonLivraison(BonLivraison bl) {
		this.bonLivraisonDAO.ajouterBonLivraison(bl);
		
	}

	@Override
	@Transactional
	public List<BonLivraison> listerBonLivraison() {
		return this.bonLivraisonDAO.listerBonLivraison();
	}

}
