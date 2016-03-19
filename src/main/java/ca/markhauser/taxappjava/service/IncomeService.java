package ca.markhauser.taxappjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ca.markhauser.taxappjava.model.Income;

@Component
public class IncomeService extends AbstractEntityService<Income> {
	
	@Autowired
	public IncomeService(CrudRepository<Income, Long> repository) {
		super(repository);
	}

}
