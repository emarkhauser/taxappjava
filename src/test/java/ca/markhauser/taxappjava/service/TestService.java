package ca.markhauser.taxappjava.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.taxappjava.TaxappjavaApplication;
import ca.markhauser.taxappjava.model.Category;
import ca.markhauser.taxappjava.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TaxappjavaApplication.class)
public class TestService {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ClientService clientService;

	@Test
	public void testAddCategory() {
		
		Category category = new Category();
		category.setName("Test Name");
		
		Category categoryResult = categoryService.create(category);
		assertEquals(category.getName(), categoryResult.getName());
	}
	
	@Test
	public void testAddClient() {
		
		Client client = new Client();
		client.setName("Test Name");
		
		Client clientResult = clientService.create(client);
		assertEquals(client.getName(), clientResult.getName());
	}

}
