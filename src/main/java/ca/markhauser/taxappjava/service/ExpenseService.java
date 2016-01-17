package ca.markhauser.taxappjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.markhauser.taxappjava.model.Expense;
import ca.markhauser.taxappjava.repository.ExpenseRepository;

@Component
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;

	public Expense create(Expense entity) {
		return expenseRepository.save(entity);
	}

	public List<Expense> readAll() {
		return (List<Expense>) expenseRepository.findAll();
	}

	public Expense read(long id) {
		return expenseRepository.findOne(id);
	}

	public Expense update(Expense entity) {
		return expenseRepository.save(entity);
	}

	public void delete(long id) {
		if (expenseRepository.exists(id)) {
			expenseRepository.delete(id);
		}
	}

}
