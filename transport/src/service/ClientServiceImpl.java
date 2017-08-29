package service;

import java.util.List;

import dao.ClientDAO;
import model.Client;

public class ClientServiceImpl implements ClientService {
	
	ClientDAO clientDAO;

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public void save(Client client) {
		clientDAO.save(client);

	}

	@Override
	public void update(Client client) {
		clientDAO.update(client);

	}

	@Override
	public void delete(Client client) {
		clientDAO.delete(client);

	}

	@Override
	public Client findByClientId(int clientId) {
		
		return clientDAO.findByClientId(clientId);
	}

	@Override
	public List<Client> getListeClient() {
		
		return clientDAO.getListeClient();
	}

}
