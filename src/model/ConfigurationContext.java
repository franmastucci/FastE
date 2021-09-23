package model;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import persistence.HibernateUtil;

@Configuration
public class ConfigurationContext {

	@Bean 
	public SessionFactory sessionFactory() {
		return HibernateUtil.getSessionFactory();
	}
		
}
