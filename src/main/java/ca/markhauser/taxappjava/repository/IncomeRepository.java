package ca.markhauser.taxappjava.repository;

import org.springframework.data.repository.CrudRepository;
import ca.markhauser.taxappjava.model.Income;

public interface IncomeRepository extends CrudRepository<Income, Long> {
}


