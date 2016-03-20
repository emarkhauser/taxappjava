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

import ca.markhauser.taxappjava.model.Client;
import ca.markhauser.taxappjava.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {

	static Logger log = Logger.getLogger(ClientController.class.getName());

	@Autowired
	private ClientService clientService;

	private final String createform = "clients/clientsCreateForm";
	private final String updateform = "clients/clientsUpdateForm";
	private final String mainTemplate = "clients/clientsReadAll";
	private final String redirectMain = "redirect:/clients";
	private final String clientName = "client";
	private final String clientsName = "clients";

	// Read All

	@RequestMapping(method = RequestMethod.GET)
	public String readAll(Model model) {
		ArrayList<Client> clients = (ArrayList<Client>) clientService.readAll();
		model.addAttribute(clientsName, clients);
		return mainTemplate;
	}

	// Create Form

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute(clientName, new Client());
		return createform;
	}

	// Create Action

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute Client client, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return createform;
		}
		clientService.create(client);
		return redirectMain;
	}

	// Read

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String read(@PathVariable("id") long id, Model model) {
		model.addAttribute(clientName, clientService.read(id));
		return updateform;
	}

	// Update Action

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") long id, @Valid @ModelAttribute Client client,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return updateform;
		}

		clientService.update(client);
		return redirectMain;
	}

	// Delete Action

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteEntity(@PathVariable("id") long id) {
		clientService.delete(id);
		return redirectMain;
	}

}
