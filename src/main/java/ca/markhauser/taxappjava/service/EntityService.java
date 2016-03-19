package ca.markhauser.taxappjava.service;

import java.util.List;

public interface EntityService<T> {

	T create(T entity);

	List<T> readAll();

	T read(long id);

	T update(T entity);

	void delete(long id);

}
