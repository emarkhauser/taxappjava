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

import ca.markhauser.taxappjava.model.Expense;
import ca.markhauser.taxappjava.service.CategoryService;
import ca.markhauser.taxappjava.service.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	
	static Logger log = Logger.getLogger(ExpenseController.class.getName());
	
	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private CategoryService categoryService;
	
	private final String createform = "expenses/expensesCreateForm";
	private final String updateform = "expenses/expensesUpdateForm";
	private final String mainTemplate = "expenses/expensesReadAll";
	private final String redirectMain = "redirect:/expenses";
	private final String expenseName = "expense";
	private final String expensesName = "expenses";
	
	// Read All

	@RequestMapping(method=RequestMethod.GET)
    public String readAll(Model model) {
		ArrayList<Expense> expenses = (ArrayList<Expense>) expenseService.readAll();
        model.addAttribute(expensesName, expenses);
        return mainTemplate;
    }
	
	// Create Form
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
    public String createForm(Model model) {
		model.addAttribute("categories", categoryService.readAll());
        model.addAttribute(expenseName, new Expense());
        return createform;
    }
	
	// Create Action
	
    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute Expense expense, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        	return createform;
        }
    	expenseService.create(expense);
        return redirectMain;
    }
    
    // Read
    
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String read(@PathVariable("id") long id, Model model) {
		model.addAttribute("categories", categoryService.readAll());
        model.addAttribute(expenseName, expenseService.read(id));
        return updateform;
    }
	
	// Update Action
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable("id") long id, @Valid @ModelAttribute Expense expense, BindingResult bindingResult) {
		
        if (bindingResult.hasErrors()) {
        	return updateform;
        }
        
        expenseService.update(expense);
        return redirectMain;
	}

	// Delete Action
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String deleteEntity(@PathVariable("id") long id) {
		expenseService.delete(id);
		return redirectMain;
	}

}
