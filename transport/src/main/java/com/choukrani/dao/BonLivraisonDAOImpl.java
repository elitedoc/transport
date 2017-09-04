package com.choukrani.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.choukrani.model.BonLivraison;
import com.choukrani.model.Client;

@Repository
public class BonLivraisonDAOImpl implements BonLivraisonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void ajouterBonLivraison(BonLivraison bl) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(bl);
        logger.info("Bon de livraison enregistre correctement, BL="+bl);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BonLivraison> listerBonLivraison() {
		Session session = this.sessionFactory.getCurrentSession();
        List<BonLivraison> listeBonLivraison = session.createQuery("from BonLivraison").list();
        for(BonLivraison bl : listeBonLivraison){
            logger.info("Liste Bon de Livraison::"+bl);
        }
        return listeBonLivraison;
	}

	@Override
	public void modifierBonLivraison(BonLivraison bl) {
		Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(bl);
        logger.info("Bon de livraison modifie correctement, BL="+bl);
		
	}

	@Override
	public void supprimerBonLivraison(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
        session.delete(session.get(BonLivraison.class, id));
        logger.info("Bon de livraison supprime correctement, ID="+id);
		
	}

	@Override
	public BonLivraison recupererBonLivraison(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (BonLivraison)session.get(BonLivraison.class, id);
		
	}

}
