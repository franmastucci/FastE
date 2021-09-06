package model.user;

import java.time.LocalDate;
import java.util.*;

import model.order.Order;
import model.provider.Product;

public class Customer extends User {
	
	private List<Order> activeOrders;
	
	private Customer() {}

	private Customer(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		super(anUserName, aPass, aName, anEmail, aBirthday);
		activeOrders = new ArrayList<Order>();
	}

	//Metodo de acceso publico para crear instancias de Customer
	public static Customer register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		return new Customer(anUserName, aPass, aName, anEmail, aBirthday);
	}

	public List<Order> getActiveOrders() {
		return activeOrders;
	}
	
	@SuppressWarnings("unused")
	private void setActiveOrders(List<Order> anOrderList) {
		this.activeOrders = anOrderList;
	}

//	public void makeAnOrder(Product aProduct, Integer aQuantity) {
//		Order.newOrder(this, aProduct, aQuantity);
//	};

	public Order makeAnOrder(Product aProduct, Integer aQuantity) {
		return Order.newOrder(this, aProduct, aQuantity);
	};
}