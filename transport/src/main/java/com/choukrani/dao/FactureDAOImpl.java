package com.choukrani.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.choukrani.model.Client;
import com.choukrani.model.Facture;

@Repository
public class FactureDAOImpl implements FactureDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void ajouterFacture(Facture fact) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(fact);
        logger.info("Facture enregistree correctement, Facture="+fact);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Facture> listerFactures() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Facture> listeFactures = session.createQuery("from Facture").list();
        for(Facture fact : listeFactures){
            logger.info("Liste Factures::"+fact);
        }
        return listeFactures;
	}

}
