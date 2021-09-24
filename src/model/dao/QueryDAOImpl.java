package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.order.Order;
import model.provider.Product;
import model.user.Customer;
import model.user.User;


@Repository(value = "queryDAO")
public class QueryDAOImpl implements QueryDAO {

	public QueryDAOImpl() {
	}

	public QueryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Order> getAllOrdersMadeByUser(String anUserName) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Order> query = session.createQuery("from Order where customer.userName = :anUserName", Order.class)
				.setParameter("anUserName", anUserName);
		
		List<Order> ordersByUser = query.getResultList();
		
		System.out.println("El resultado de la query es: ");
		
		return ordersByUser;
	}

	
	@Override
	@Transactional
	public List<Customer> getUsersSpendingMoreThan() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("FROM Customer ", Customer.class);
		
		List<Customer> users = query.getResultList();
		
		return users;
	}
	


	@Override
	@Transactional
	public List<Product> getTop10MoeExpensiveProducts() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Product>  query = session.createQuery("SELECT product FROM CurrentPrice ", Product.class);
		
		List<Product>  expensiveProducts = query.getResultList();
		
		return expensiveProducts;
	}

	
	@Override
	@Transactional
	public List<Order> getPendingOrders() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Order> query = session.createQuery("From Order WHERE state = '' ", Order.class);  
		
		List<Order>  pendingOrders = query.getResultList();
		
		return pendingOrders;
	}
	

	
	@Override
	@Transactional
	public List<Order> getCancelledOrdersInPeriod() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Order> query = session.createQuery("From Order", Order.class);  
		
		List<Order>  cancelledOrders = query.getResultList();
		
		return cancelledOrders;
	}

	
	@Override
	@Transactional
	public List<Order> getDeliveredOrdersForUser() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		Query<Order> query= session.createQuery("From Order", Order.class);
		
		List<Order> deliveredOrders = query.getResultList();
		
		return deliveredOrders;
	}
	

	@Override
	@Transactional
	public List<String> getProductsOnePrice() {

		Session session = this.sessionFactory.getCurrentSession();		
		
		@SuppressWarnings("unchecked")
		Query<String> query = session.createQuery("select name from Product where name not in "
																+ "(select distinct product from PriceRecord)" ); 
		List<String> products = query.getResultList();
		
		return products;
	}
	

	@Override
	@Transactional
	public List<Product> getSoldProductsOn() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		Query<Product> query= session.createQuery("From Product", Product.class);
		
		List<Product> soldOnProducts= query.getResultList();
		
		return soldOnProducts;
	}

	
	@Override
	@Transactional
	public List<Product> getProductsWithPriceAt() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		Query<Product> query= session.createQuery("From Product", Product.class);
		
		List<Product> productsWithPrice= query.getResultList();
		
		return productsWithPrice;
	}
	

	@Override
	@Transactional
	public List<String> getProductsNotSold() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		Query<String> query= session.createQuery("SELECT name FROM Product where name not "
														+ "	in(select distinct product from Order)", String.class);
		
		List<String> notSoldProducts= query.getResultList();
		
		return notSoldProducts;		
		
	}
	
}