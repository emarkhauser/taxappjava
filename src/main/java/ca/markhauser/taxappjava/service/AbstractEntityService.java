package ca.markhauser.taxappjava.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public abstract class AbstractEntityService<T> implements EntityService<T> {

	private CrudRepository<T, Long> repository;
	
	public AbstractEntityService(CrudRepository<T, Long> repository) {
		this.repository = repository;
	}

	public T create(T entity) {
		return repository.save(entity);
	}

	public List<T> readAll() {
		return (List<T>) repository.findAll();
	}

	public T read(long id) {
		return repository.findOne(id);
	}

	public T update(T entity) {
		return repository.save(entity);
	}

	public void delete(long id) {
		if (repository.exists(id)) {
			repository.delete(id);
		}
	}

}
