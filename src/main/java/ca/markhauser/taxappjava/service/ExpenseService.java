package ca.markhauser.taxappjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ca.markhauser.taxappjava.model.Expense;

@Component
public class ExpenseService extends AbstractEntityService<Expense> {
	
	@Autowired
	public ExpenseService(CrudRepository<Expense, Long> repository) {
		super(repository);
	}

}
