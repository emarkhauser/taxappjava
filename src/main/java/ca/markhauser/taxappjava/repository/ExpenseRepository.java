package ca.markhauser.taxappjava.repository;

import org.springframework.data.repository.CrudRepository;
import ca.markhauser.taxappjava.model.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
}


