package ca.markhauser.taxappjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ca.markhauser.taxappjava.model.Category;

@Configuration
public class TaxappjavaConfig {

	@Bean(name = "category")
	@Scope("prototype")
	public Category category() {
		return new Category();
	}

}
