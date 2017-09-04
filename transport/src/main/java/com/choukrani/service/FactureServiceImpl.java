package com.choukrani.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choukrani.dao.FactureDAO;
import com.choukrani.model.Facture;

@Service
public class FactureServiceImpl implements FactureService {
	
	FactureDAO factureDAO;
	
	

	public void setFactureDAO(FactureDAO factureDAO) {
		this.factureDAO = factureDAO;
	}



	@Override
	@Transactional
	public void ajouterFacture(Facture fact) {
		this.factureDAO.ajouterFacture(fact);
		
	}



	@Override
	@Transactional
	public List<Facture> listerFactures() {
		return this.factureDAO.listerFactures();
	}



	@Override
	@Transactional
	public void modifierFacture(Facture fact) {
		this.factureDAO.modifierFacture(fact);
		
	}



	@Override
	@Transactional
	public void supprimerFacture(Long id) {
		this.factureDAO.supprimerFacture(id);
		
	}



	@Override
	@Transactional
	public Facture recupererFacture(Long id) {
		return this.factureDAO.recupererFacture(id);
	}

}
