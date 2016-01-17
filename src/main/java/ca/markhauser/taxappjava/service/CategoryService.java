package ca.markhauser.taxappjava.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.markhauser.taxappjava.model.Category;
import ca.markhauser.taxappjava.repository.CategoryRepository;

@Component
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public Category create(Category entity) {
		return categoryRepository.save(entity);
	}

	public List<Category> readAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	public Category read(long id) {
		return categoryRepository.findOne(id);
	}

	public Category update(Category entity) {
		return categoryRepository.save(entity);
	}

	public void delete(long id) {
		if (categoryRepository.exists(id)) {
			categoryRepository.delete(id);
		}
	}

}
