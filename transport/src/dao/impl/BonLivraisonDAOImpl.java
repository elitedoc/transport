package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import dao.BonLivraisonDAO;
import model.BonLivraison;
import model.Client;

public class BonLivraisonDAOImpl implements BonLivraisonDAO {
	
	Session getSession() {

		return new Configuration().configure().buildSessionFactory().openSession();

	}

	@Override
	public void save(BonLivraison bonLivraison) {
		getSession().persist(bonLivraison);

	}

	@Override
	public void update(BonLivraison bonLivraison) {
		getSession().update(bonLivraison);

	}

	@Override
	public void delete(BonLivraison bonLivraison) {
		getSession().delete(bonLivraison);

	}

	@Override
	public BonLivraison findByBonLivraisonId(int bonLivraisonId) {
		BonLivraison bonLivraison = getSession().get(BonLivraison.class,bonLivraisonId);
		return bonLivraison;
	}

	@Override
	public List<BonLivraison> getListeBonLivraison() {
		List<BonLivraison> bonsLivraison=new ArrayList<BonLivraison>();  
	    Criteria criteria = getSession().createCriteria(BonLivraison.class);
	    bonsLivraison = criteria.list();
	    return bonsLivraison;
	}

}
