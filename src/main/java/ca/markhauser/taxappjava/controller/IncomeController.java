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

import ca.markhauser.taxappjava.model.Income;
import ca.markhauser.taxappjava.service.ClientService;
import ca.markhauser.taxappjava.service.EntityService;

@Controller
@RequestMapping("/incomes")
public class IncomeController extends AbstractEntityController<Income> {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	public IncomeController(EntityService<Income> service) {
		super(service, "income", "incomes");
	}
	
	// Read All

	@RequestMapping(method = RequestMethod.GET)
	public String readAll(Model model) {
		return super.readAll(model);
	}

	// Create Form

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("clients", clientService.readAll());
		return super.createForm(model);
	}

	// Create Action

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute Income income, BindingResult bindingResult) {
		return super.create(income, bindingResult);
	}

	// Read

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String read(@PathVariable("id") long id, Model model) {
		model.addAttribute("clients", clientService.readAll());
		return super.read(id, model);
	}

	// Update Action

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") long id, @Valid @ModelAttribute Income income,
			BindingResult bindingResult) {
		return super.update(id, income, bindingResult);
	}

	// Delete Action

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteEntity(@PathVariable("id") long id) {
		return super.deleteEntity(id);
	}

}
