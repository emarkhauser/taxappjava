package ca.markhauser.taxappjava.repository;

import org.springframework.data.repository.CrudRepository;
import ca.markhauser.taxappjava.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
}


