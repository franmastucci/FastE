package model.user;

import java.time.LocalDate;
import java.util.*;

import org.apache.commons.codec.digest.DigestUtils;

import model.order.Order;
import model.provider.Product;

public class Customer extends User {
	
	private List<Order> activeOrders;
	
	protected Customer() {}

	//Requerido por hibernate
	protected Customer(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday, 
			List<Order>	anActiveOrderList) {
		
		super(anUserName, aPass, aName, anEmail, aBirthday);
		activeOrders = anActiveOrderList;
	}

	//Metodo de acceso publico para crear instancias de Customer
	public static Customer register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		
		List<Order> anActiveOrders = new ArrayList<Order>();
		return new Customer(anUserName, aPass, aName, anEmail, aBirthday, anActiveOrders);
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
	}

	@Override
	public Customer copyToPersist() {
		String encryptedPass = DigestUtils.sha1Hex(pass);
		return new Customer(this.getUserName(), encryptedPass, this.getName(), this.getEmail(), this.getBirthday(), 
				this.getActiveOrders());
	}
}