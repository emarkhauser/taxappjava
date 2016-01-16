package ca.markhauser.taxappjava.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ca.markhauser.taxappjava.model.Client;
import ca.markhauser.taxappjava.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@RequestMapping
    public String readAll(Model model) {
		ArrayList<Client> clients = (ArrayList<Client>) clientService.readAll();
        model.addAttribute("clients", clients);
        return "clients/clientsReadAll";
    }
	
}
