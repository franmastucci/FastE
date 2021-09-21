package model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import model.provider.Provider;


@Configuration
@ComponentScan("model")
public class ConfigurationContext {

	@Bean 
	public Provider providerConstructor() {
		return new Provider();
	}
		
}
