package model.dao;

import java.time.LocalDate;
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
		
		Query<Order> query = session.createNativeQuery( "SELECT * FROM CUSTOMER_ORDER WHERE customer = :anUserName", Order.class)
				.setParameter("anUserName", anUserName);
		
		List<Order> ordersByUser = query.getResultList();
		
		System.out.println("El resultado de la query N° 1 es: ");
		
		return ordersByUser;
	}

	
	@Override
	@Transactional
	public List<Customer> getUsersSpendingMoreThan(float amount) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		
		Query<Customer> query = session.createNativeQuery("SELECT DISTINCT  USER_NAME, pass, name, email, birthday "
				+ "FROM CUSTOMER_ORDER JOIN USER ON CUSTOMER_ORDER.customer = USER.USER_NAME "
				+ "WHERE (CUSTOMER_ORDER.quantity * CUSTOMER_ORDER.unitaryPrice) > :amount ", Customer.class)
				.setParameter("amount", amount );
		
		List<Customer> users = query.getResultList();
		
		System.out.println("El resultado de la query N° 2 es: ");
		
		return users;
	}
	


	@Override
	@Transactional
	public List<Product> getTop10MoreExpensiveProducts() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Product>  query = session.createNativeQuery("SELECT NAME,weight,provider,price_id FROM PRODUCT as p "
				+ "JOIN PRICE_LIST as l ON p.price_id = l.id ORDER BY value LIMIT 10", Product.class);
		
		List<Product>  expensiveProducts = query.getResultList();
		
		System.out.println("El resultado de la query N° 3 es: ");
		
		return expensiveProducts;
	}
	
	@Override
	@Transactional
	public List<Order> getPendingOrders() {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Order> query = session.createNativeQuery("SELECT * FROM CUSTOMER_ORDER WHERE state = 'Pendiente'", Order.class);  
		
		List<Order>  pendingOrders = query.getResultList();
		
		System.out.println("El resultado de la query N° 4 es: ");
		
		return pendingOrders;
	}
	
	@Override
	@Transactional
	public List<Order> getCancelledOrdersInPeriod(LocalDate startDate, LocalDate endDate) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query<Order> query = session.createNativeQuery("SELECT * FROM CUSTOMER_ORDER "
				+ "WHERE lastStateModification BETWEEN :aStartDate AND :anEndDate "
				+ "AND state = 'Cancelado'", Order.class)
				.setParameter("aStartDate", startDate).setParameter("anEndDate", endDate);  
		
		List<Order>  cancelledOrders = query.getResultList();
		
		System.out.println("El resultado de la query N° 5 es: ");
		
		return cancelledOrders;
	}
	
	@Override
	@Transactional
	public List<Order> getDeliveredOrdersForUser(String username) {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		LocalDate today = LocalDate.now();
		LocalDate tenDaysAgo = today.minusDays(10);
		
		Query<Order> query= session.createNativeQuery("SELECT orderNumber, quantity, customer, product_name, state, creationDate,"
				+ " lastStateModification, unitaryPrice FROM CUSTOMER_ORDER "
				+ "JOIN DELIVER ON CUSTOMER_ORDER.orderNumber = DELIVER.order_id "
				+ "WHERE lastStateModification BETWEEN :tenDaysAgo AND :today "
				+ "AND state = 'Entregado' AND delivery = :username ORDER BY lastStateModification", Order.class)
				.setParameter("today", today).setParameter("tenDaysAgo", tenDaysAgo).setParameter("username", username);
		
		List<Order> deliveredOrders = query.getResultList();

		System.out.println("El resultado de la query N° 6 es: ");
		
		return deliveredOrders;
	}
	

	@Override
	@Transactional
	public List<Product> getProductsOnePrice() {

		Session session = this.sessionFactory.getCurrentSession();		
		
		Query<Product> query = session.createNativeQuery("SELECT * FROM PRODUCT "
				+ "WHERE NAME NOT IN (SELECT DISTINCT product FROM PRICE_STORY)", Product.class); 

		List<Product> products = query.getResultList();

		System.out.println("El resultado de la query N° 7 es: ");
		
		return products;
	}
	

	@Override
	@Transactional
	public List<Product> getSoldProductsOn(LocalDate day) {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		Query<Product> query= session.createNativeQuery("SELECT NAME, weight, provider, price_id FROM PRODUCT AS p "
				+ "JOIN CUSTOMER_ORDER AS o ON p.NAME = o.product_name WHERE creationDate = :day", Product.class)
				.setParameter("day", day);
		
		List<Product> soldOnProducts= query.getResultList();

		System.out.println("El resultado de la query N° 8 es: ");
		
		return soldOnProducts;
	}

	
	@Override
	@Transactional
	public List<Product> getProductsWithPriceAt() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		Query<Product> query= session.createQuery("From Product", Product.class);
		
		List<Product> productsWithPrice= query.getResultList();
		
		System.out.println("El resultado de la query N° 9 es: ");
		
		return productsWithPrice;
	}
	

	@Override
	@Transactional
	public List<Product> getProductsNotSold() {
		
		Session session = this.sessionFactory.getCurrentSession();		
		
		Query<Product> query= session.createNativeQuery("SELECT * FROM PRODUCT WHERE NAME NOT IN (SELECT DISTINCT product_name FROM CUSTOMER_ORDER)", Product.class);
		
		List<Product> notSoldProducts= query.getResultList();
		
		System.out.println("El resultado de la query N° 10 es: ");
		
		return notSoldProducts;		
		
	}
	
}