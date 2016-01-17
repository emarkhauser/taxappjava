package ca.markhauser.taxappjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.markhauser.taxappjava.model.Income;
import ca.markhauser.taxappjava.repository.IncomeRepository;

@Component
public class IncomeService {
	
	@Autowired
	private IncomeRepository incomeRepository;

	public Income create(Income entity) {
		return incomeRepository.save(entity);
	}

	public List<Income> readAll() {
		return (List<Income>) incomeRepository.findAll();
	}

	public Income read(long id) {
		return incomeRepository.findOne(id);
	}

	public Income update(Income entity) {
		return incomeRepository.save(entity);
	}

	public void delete(long id) {
		if (incomeRepository.exists(id)) {
			incomeRepository.delete(id);
		}
	}

}
