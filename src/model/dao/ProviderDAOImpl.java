package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.provider.Provider;

@Repository(value = "providerDAO")
public class ProviderDAOImpl implements ProviderDAO {

	public ProviderDAOImpl() {
	}

	public ProviderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Provider> getProviders() {

		//obtener sesion
		Session session = this.sessionFactory.getCurrentSession();
		
//		session.beginTransaction();
		
		//crear query
		Query<Provider> query = session.createQuery("FROM Provider", Provider.class);
		
		//almacenar resultado
		
		List<Provider> providers = query.getResultList();
		
		return providers;
	}

}
