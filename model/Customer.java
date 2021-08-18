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

	public List<Order> getActiveOrders() {
		return activeOrders;
	}

	@Override
	public User register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		
		return new Customer (anUserName, aPass, aName, anEmail, aBirthday);
	}
}
