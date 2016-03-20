package ca.markhauser.taxappjava.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.markhauser.taxappjava.service.EntityService;

public abstract class AbstractEntityController<T> implements EntityController<T> {

	@Autowired
	private ApplicationContext appContext;

	private EntityService<T> service;

	private String createform, updateform, mainTemplate, redirectMain, entityName, entitiesName;

	public AbstractEntityController(EntityService<T> service, String createform, String updateform,
			String mainTemplate, String redirectMain, String entityName, String entitiesName) {
		this.service = service;
		this.createform = createform;
		this.updateform = updateform;
		this.mainTemplate = mainTemplate;
		this.redirectMain = redirectMain;
		this.entityName = entityName;
		this.entitiesName = entitiesName;
	}

	// Read All

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.taxappjava.controller.EntityController#readAll(org.
	 * springframework.ui.Model)
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String readAll(Model model) {
		ArrayList<T> categories = (ArrayList<T>) service.readAll();
		model.addAttribute(entitiesName, categories);
		return mainTemplate;
	}

	// Create Form

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.taxappjava.controller.EntityController#createForm(org.
	 * springframework.ui.Model)
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(Model model) {
		T entity = (T) appContext.getBean(this.entityName);
		model.addAttribute(entityName, entity);
		return createform;
	}

	// Create Action

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.taxappjava.controller.EntityController#create(T,
	 * org.springframework.validation.BindingResult)
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute T entity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return createform;
		}
		service.create(entity);
		return redirectMain;
	}

	// Read

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.taxappjava.controller.EntityController#read(long,
	 * org.springframework.ui.Model)
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String read(@PathVariable("id") long id, Model model) {
		model.addAttribute(entityName, service.read(id));
		return updateform;
	}

	// Update Action

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.taxappjava.controller.EntityController#update(long, T,
	 * org.springframework.validation.BindingResult)
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") long id, @Valid @ModelAttribute T entity, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return updateform;
		}

		service.update(entity);
		return redirectMain;
	}

	// Delete Action

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.markhauser.taxappjava.controller.EntityController#deleteEntity(long)
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteEntity(@PathVariable("id") long id) {
		service.delete(id);
		return redirectMain;
	}

}
