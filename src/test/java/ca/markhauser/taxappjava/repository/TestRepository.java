/**
 * 
 */
package ca.markhauser.taxappjava.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.taxappjava.TaxappjavaApplication;
import ca.markhauser.taxappjava.model.Category;

/**
 * @author Erik Markhauser
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TaxappjavaApplication.class)
public class TestRepository {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Test
	public void testAddCategory() {
		Category category = categoryRepository.save(new Category("test"));
		assertEquals(1, categoryRepository.count());
	}

}
