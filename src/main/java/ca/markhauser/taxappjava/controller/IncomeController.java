package ca.markhauser.taxappjava.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import ca.markhauser.taxappjava.service.IncomeService;

@Controller
@RequestMapping("/incomes")
public class IncomeController {

	static Logger log = Logger.getLogger(IncomeController.class.getName());

	@Autowired
	private IncomeService incomeService;

	@Autowired
	private ClientService clientService;

	private final String createform = "incomes/incomesCreateForm";
	private final String updateform = "incomes/incomesUpdateForm";
	private final String mainTemplate = "incomes/incomesReadAll";
	private final String redirectMain = "redirect:/incomes";
	private final String incomeName = "income";
	private final String incomesName = "incomes";

	// Read All

	@RequestMapping(method = RequestMethod.GET)
	public String readAll(Model model) {
		ArrayList<Income> incomes = (ArrayList<Income>) incomeService.readAll();
		model.addAttribute(incomesName, incomes);
		return mainTemplate;
	}

	// Create Form

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("clients", clientService.readAll());
		model.addAttribute(incomeName, new Income());
		return createform;
	}

	// Create Action

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute Income income, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return createform;
		}
		incomeService.create(income);
		return redirectMain;
	}

	// Read

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String read(@PathVariable("id") long id, Model model) {
		model.addAttribute("clients", clientService.readAll());
		model.addAttribute(incomeName, incomeService.read(id));
		return updateform;
	}

	// Update Action

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") long id, @Valid @ModelAttribute Income income,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return updateform;
		}

		incomeService.update(income);
		return redirectMain;
	}

	// Delete Action

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteEntity(@PathVariable("id") long id) {
		incomeService.delete(id);
		return redirectMain;
	}

}
