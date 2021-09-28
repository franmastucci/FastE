package model.dao;

import java.time.LocalDate;
import java.util.List;

import model.order.Order;
import model.provider.Product;
import model.user.Customer;
import model.user.User;

public interface QueryDAO {
	
	public List<Order> getAllOrdersMadeByUser(String anUserName); //recbe un String username
	
	public List<Customer> getUsersSpendingMoreThan(float amount); //recibe un float amount
	
	public List<Product> getTop10MoreExpensiveProducts();
	
	public List<Order>  getPendingOrders();
	
	public List<Order>  getCancelledOrdersInPeriod(LocalDate startDate, LocalDate finishDate); //recibe un Date startDate y un Date finishDate 
	
	public List<Order>  getDeliveredOrdersForUser(String username); // recibe un String username

	public List<Product> getProductsOnePrice();

	public List<Product> getSoldProductsOn(LocalDate day); //recibe un Date day
	
	public List<Product>  getProductsWithPriceAt(); //recibe un Date day
	
	public List<Product> getProductsNotSold();
	
	
}
