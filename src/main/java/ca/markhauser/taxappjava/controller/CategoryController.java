package ca.markhauser.taxappjava.controller;

import java.util.ArrayList;

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
import ca.markhauser.taxappjava.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	private final String createform = "categories/categoriesCreateForm";
	private final String updateform = "categories/categoriesUpdateForm";
	private final String mainTemplate = "categories/categoriesReadAll";
	private final String redirectMain = "redirect:/categories";
	private final String categoryName = "category";
	private final String categoriesName = "categories";
	
	// Read All

	@RequestMapping(method=RequestMethod.GET)
    public String readAll(Model model) {
		ArrayList<Category> categories = (ArrayList<Category>) categoryService.readAll();
        model.addAttribute(categoriesName, categories);
        return mainTemplate;
    }
	
	// Create Form
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute(categoryName, new Category());
        return createform;
    }
	
	// Create Action
	
    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute Category category, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        	return createform;
        }
    	categoryService.create(category);
        return redirectMain;
    }
    
    // Read
    
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String read(@PathVariable("id") long id, Model model) {
        model.addAttribute(categoryName, categoryService.read(id));
        return updateform;
    }
	
	// Update Form
	
	@RequestMapping(value="/{id}/update", method=RequestMethod.GET)
	public String updateForm(@PathVariable("id") long id, Model model) {
		model.addAttribute(categoryName, categoryService.read(id));
		return updateform;
    }
	
	// Update Action
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@Valid @PathVariable("id") long id, BindingResult bindingResult) {
		Category category = categoryService.read(id);
		
        if (bindingResult.hasErrors()) {
        	return updateform;
        }
        
        categoryService.update(category);
        return redirectMain;
	}

	// Delete Action
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String deleteEntity(@PathVariable("id") long id) {
		categoryService.delete(id);
		return redirectMain;
	}

}
