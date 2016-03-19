/**
 * 
 */
package ca.markhauser.taxappjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ca.markhauser.taxappjava.model.Client;

@Component
public class ClientService extends AbstractEntityService<Client> {
	
	@Autowired
	public ClientService(CrudRepository<Client, Long> repository) {
		super(repository);
	}

}
