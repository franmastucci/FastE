package model;

import java.time.LocalDate;
import java.util.*;

public class Delivery extends User {
	
	private Integer capacity;
	private final List<Order> takenOrders;
	
	private Delivery(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		userName = anUserName;
		pass = aPass;
		name = aName;
		email = anEmail;
		birthday = aBirthday;
		takenOrders = new ArrayList<Order>();
	}
	
	public List<Order> getTakenOrders() {
		return takenOrders;
	}

	public Integer getCapacity() {
		return capacity;
	}

	@Override
	public User register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
	
		return new Delivery(anUserName, aPass, aName, anEmail, aBirthday);
	}
}
