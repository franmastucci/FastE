package model.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import model.order.Order;


public class Delivery extends User {
	
	private Float capacity;
	private List<Order> deliveredOrders;
	
	protected Delivery() {}

	//Requerido por hibernate	
	protected Delivery(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday, Float aCapacity, 
			List<Order> aDeliveredOrdersList) {
		
		super(anUserName, aPass, aName, anEmail, aBirthday);
		capacity = aCapacity;
		deliveredOrders = aDeliveredOrdersList;
	}

	//Metodo de acceso publico para crear instancias de Delivery
	public static Delivery register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday, 
			Float aCapacity) {
		
		List<Order> aDeliveredOrders = new ArrayList<Order>();
		return new Delivery(anUserName, aPass, aName, anEmail, aBirthday, aCapacity, aDeliveredOrders);
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

	@Override
	public Delivery copyToPersist() {
		String encryptedPass = DigestUtils.sha1Hex(pass);
		return new Delivery(this.getUserName(), encryptedPass, this.getName(), this.getEmail(), this.getBirthday(), 
				this.getCapacity(), this.getDeliveredOrders());
	}	
}
