package ca.markhauser.taxappjava.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.markhauser.taxappjava.model.Category;
import ca.markhauser.taxappjava.service.EntityService;

@Controller
@RequestMapping("/categories")
public class CategoryController extends AbstractEntityController<Category> {

	@Autowired
	public CategoryController(EntityService<Category> service) {
		super(service, "category", "categories");
	}

	// Read All

	@RequestMapping(method = RequestMethod.GET)
	public String readAll(Model model) {
		return super.readAll(model);
	}

	// Create Form

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(Model model) {
		return super.createForm(model);
	}

	// Create Action

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute Category category, BindingResult bindingResult) {
		return super.create(category, bindingResult);
	}

	// Read

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String read(@PathVariable("id") long id, Model model) {
		return super.read(id, model);
	}

	// Update Action

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") long id, @Valid @ModelAttribute Category category,
			BindingResult bindingResult) {
		return super.update(id, category, bindingResult);
	}

	// Delete Action

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteEntity(@PathVariable("id") long id) {
		return super.deleteEntity(id);
	}

}
