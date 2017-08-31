package com.choukrani.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.choukrani.model.Client;

@Repository
public class ClientDAOImpl implements ClientDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void ajouterClient(Client cl) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(cl);
        logger.info("Client enregistre correctement, Client="+cl);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> listerClients() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Client> listeClients = session.createQuery("from Client").list();
        for(Client cl : listeClients){
            logger.info("Liste Clients::"+cl);
        }
        return listeClients;
	}	
	

}
