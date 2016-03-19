package ca.markhauser.taxappjava.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.markhauser.taxappjava.model.Client;
import ca.markhauser.taxappjava.model.Income;

public interface IncomeRepository extends CrudRepository<Income, Long> {
	
	List<Income> findDistinctIncomesByClient(Client client);
	
}


