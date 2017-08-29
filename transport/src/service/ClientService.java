package service;

import java.util.List;

import model.Client;

public interface ClientService {
	
	void save(Client client);
	void update(Client client);
	void delete(Client client);
	Client findByClientId(int clientId);
	List<Client> getListeClient();

}
