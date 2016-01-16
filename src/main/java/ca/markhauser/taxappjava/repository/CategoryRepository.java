package ca.markhauser.taxappjava.repository;

import org.springframework.data.repository.CrudRepository;
import ca.markhauser.taxappjava.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}