package ca.markhauser.taxappjava.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface EntityController<T> {

	String readAll(Model model);

	String createForm(Model model);

	String create(T entity, BindingResult bindingResult);

	String read(long id, Model model);

	String update(long id, T entity, BindingResult bindingResult);

	String deleteEntity(long id);

}