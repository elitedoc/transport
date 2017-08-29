package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import model.Client;

public class ClientDAOImpl implements ClientDAO {

	Session getSession() {

		return new Configuration().configure().buildSessionFactory().openSession();

	}

	@Override
	public void save(Client client) {
		getSession().persist(client);
		
	}

	@Override
	public void update(Client client) {
		getSession().update(client);
		
	}

	@Override
	public void delete(Client client) {
		getSession().delete(client);
		
	}

	@Override
	public Client findByClientId(int clientId) {
		
		Client client = getSession().get(Client.class,clientId);
		return client;
	}

	@Override
	public List<Client> getListeClient() {
		List<Client> clients=new ArrayList<Client>();  
	    Criteria criteria = getSession().createCriteria(Client.class);
	    clients = criteria.list();
	    return clients; 
	}
	
	

}
