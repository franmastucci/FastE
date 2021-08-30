package model;

import java.time.LocalDate;
import java.util.*;

public class Customer extends User {
	
	private final List<Order> activeOrders;
	
	private Customer(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		userName = anUserName;
		pass = aPass;
		name = aName;
		email = anEmail;
		birthday = aBirthday;
		activeOrders = new ArrayList<Order>();
	}
	//el m�todo de clase "register" est� pensado para realizar las validaciones antes de construir una instancia de
	// "Customer" y para evitar que el contructor sea de acceso p�blico
	public static Customer register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		return new Customer (anUserName, aPass, aName, anEmail, aBirthday);
	}

	public void makeAnOrder(Integer orderNumber, Integer aQuantity, Product aProduct) {
		Order.newOrder(orderNumber, aQuantity, this, aProduct);
	};
	
	public List<Order> getActiveOrders() {
		return activeOrders;
	}
}
