package ca.markhauser.taxappjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ca.markhauser.taxappjava.model.Category;

@Component
public class CategoryService extends AbstractEntityService<Category> {
	
	@Autowired
	public CategoryService(CrudRepository<Category, Long> repository) {
		super(repository);
	}
	
}
