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
	public List<Order> getAllOrdersMadeByUser() {
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Order> query = session.createQuery("SELECT * FROM CUSTOMER_ORDER WHERE customer_user_name = \"Pepe\"", Order.class);
		
		List<Order> ordersByUser = query.getResultList();
		
		return ordersByUser;
	}
	
	
	@Override
	@Transactional
	public List<User> getUsersSpendingMoreThan() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<User> query = session.createQuery("");
		
		List<User> users = query.getResultList();
		
		return users;
	}
	

	@Override
	@Transactional
	public List<Product> getTop10MoeExpensiveProducts() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<Product>  query = session.createQuery("SELECT product FROM PRICE_LIST ORDER BY value LIMIT 10");
		
		List<Product>  expensiveProducts = query.getResultList();
		
		return expensiveProducts;
	}

	
	@Override
	@Transactional
	public List<Order> getPendingOrders() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<Order> query = session.createQuery("SELECT * FROM CUSTOMER_ORDER WHERE state = \"Pendiente\"");  
		
		List<Order>  pendingOrders = query.getResultList();
		
		return pendingOrders;
	}

	
	@Override
	@Transactional
	public List<Order> getCancelledOrdersInPeriod() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<Order> query = session.createQuery("");  
		
		List<Order>  cancelledOrders = query.getResultList();
		
		return cancelledOrders;
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
	public List<Order> getDeliveredOrdersForUser() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		@SuppressWarnings("unchecked")
		Query<Order> query= session.createQuery("");
		
		List<Order> deliveredOrders = query.getResultList();
		
		return deliveredOrders;
	}
	

	@Override
	@Transactional
	public List<Product> getSoldProductsOn() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		@SuppressWarnings("unchecked")
		Query<Product> query= session.createQuery("");
		
		List<Product> soldOnProducts= query.getResultList();
		
		return soldOnProducts;
	}

	
	@Override
	@Transactional
	public List<Object[]> getProductsWithPriceAt() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		@SuppressWarnings("unchecked")
		Query<Object[]> query= session.createQuery("");
		
		List<Object[]> productsWithPrice= query.getResultList();
		
		return productsWithPrice;
	}
	

	@Override
	@Transactional
	public List<Product> getProductsNotSold() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		Query<Product> query= session.createQuery(" SELECT NAME FROM Product WHERE NAME NOT IN "
																+ "(SELECT DISTINCT product_name FROM DeliverOrder)", Product.class);
		
		List<Product> notSoldProducts= query.getResultList();
		
		return notSoldProducts;
		
	}
	
}