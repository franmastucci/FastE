package model;

import java.time.LocalDate;
import java.util.*;

public class Customer extends User {
	
	private List<Order> activeOrders;
	
	private Customer() {}
	
	//el m�todo de clase "register" est� pensado para realizar las validaciones antes de construir una instancia de
	// "Customer" y para evitar que el contructor sea de acceso p�blico
	public static Customer register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		Customer newCustomer = new Customer();
		List<Order> anOrderList = new ArrayList<Order>();
		newCustomer.setUserName(anUserName);
		newCustomer.setPass(aPass);
		newCustomer.setName(aName);
		newCustomer.setEmail(anEmail);
		newCustomer.setBirthday(aBirthday);
		newCustomer.setActiveOrders(anOrderList);
		return newCustomer;
	}

	public List<Order> getActiveOrders() {
		return activeOrders;
	}
	
	private void setActiveOrders(List<Order> anOrderList) {
		this.activeOrders = anOrderList;
	}

	public void makeAnOrder(Integer orderNumber, Integer aQuantity, Product aProduct) {
		Order.newOrder(orderNumber, aQuantity, this, aProduct);
	};
	
}