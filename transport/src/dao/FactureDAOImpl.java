package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import model.Client;
import model.Facture;

public class FactureDAOImpl implements FactureDAO {
	
	Session getSession() {

		return new Configuration().configure().buildSessionFactory().openSession();

	}

	@Override
	public void save(Facture facture) {
		getSession().persist(facture);

	}

	@Override
	public void update(Facture facture) {
		getSession().update(facture);

	}

	@Override
	public void delete(Facture facture) {
		getSession().delete(facture);

	}

	@Override
	public Facture findByFactureId(int factureId) {
		Facture facture = getSession().get(Facture.class,factureId);
		return facture;
	}

	@Override
	public List<Facture> getListeFacture() {
		List<Facture> factures=new ArrayList<Facture>();  
	    Criteria criteria = getSession().createCriteria(Facture.class);
	    factures = criteria.list();
	    return factures;
	}

}
