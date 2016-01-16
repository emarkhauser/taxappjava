/**
 * 
 */
package ca.markhauser.taxappjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ca.markhauser.taxappjava.model.Client;
import ca.markhauser.taxappjava.repository.ClientRepository;

@Component
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Client create(Client entity) {
		return clientRepository.save(entity);
	}

	public List<Client> readAll() {
		return (List<Client>) clientRepository.findAll();
	}

	public Client read(long id) {
		return clientRepository.findOne(id);
	}

	public Client update(Client entity) {
		return clientRepository.save(entity);
	}

	public void delete(long id) {
		if (clientRepository.exists(id)) {
			clientRepository.delete(id);
		}
	}

}
