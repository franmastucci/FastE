package model.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.order.Order;


public class Delivery extends User {
	
	private Float capacity;
	private List<Order> deliveredOrders;
	
	private Delivery() {}
	
	private Delivery(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday, Float aCapacity) {
		super(anUserName, aPass, aName, anEmail, aBirthday);
		capacity = aCapacity;
		deliveredOrders = new ArrayList<Order>();
	}

	//Metodo de acceso publico para crear instancias de Delivery
	public static Delivery register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday, Float aCapacity) {
		return new Delivery(anUserName, aPass, aName, anEmail, aBirthday, aCapacity);
	}
	
	public Float getCapacity() {
		return capacity;
	}
	
	@SuppressWarnings("unused")
	private void setCapacity(Float aCapacity) {
		this.capacity = aCapacity;
	}	

	public List<Order> getDeliveredOrders() {
		return deliveredOrders;
	}

	@SuppressWarnings("unused")
	private void setDeliveredOrders(List<Order> aListOfDeliveredOrders) {
		deliveredOrders = aListOfDeliveredOrders;
	}	
	
	public void deliver(Order anOrder) {
		anOrder.getArrive();
		this.getDeliveredOrders().add(anOrder);
	}	
}
