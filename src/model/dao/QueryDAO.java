package model.dao;

import java.util.List;
import model.order.Order;
import model.provider.Product;
import model.user.User;

public interface QueryDAO {
	
	
	public List<Order> getAllOrdersMadeByUser(); //recbe un String username
	
	public List<User> getUsersSpendingMoreThan(); //recibe un float amount
	
	public List<Product> getTop10MoeExpensiveProducts();
	
	public List<Order>  getPendingOrders();
	
	public List<Order>  getCancelledOrdersInPeriod(); //recibe un Date startDate y un Date finishDate 
	
	public List<Order>  getDeliveredOrdersForUser(); // recibe un String username

	public List<String> getProductsOnePrice();

	public List<Product> getSoldProductsOn(); //recibe un Date day
	
	public List<Object[]>  getProductsWithPriceAt(); //recibe un Date day
	
	public List<Product> getProductsNotSold();
	
	
}
