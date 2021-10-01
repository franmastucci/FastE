package model.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.order.Order;


public class Delivery extends User {
	
	private static final String INVALID_CAPACITY = "La capacidad debe ser mayor que 0 y menor que 20";
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
		
		assertIsValidUserName(anUserName);
		assertIsValidPass(aPass);
		assertIsValidName(aName);
		assertIsValidEmail(anEmail);
		assertIsvalidBirthday(aBirthday);
		assertIsValidCapacity(aCapacity);
		
		List<Order> aDeliveredOrders = new ArrayList<Order>();
		return new Delivery(anUserName, aPass, aName, anEmail, aBirthday, aCapacity, aDeliveredOrders);
	}

	private static void assertIsValidCapacity(Float aCapacity) {
		if(!isValidCapacity(aCapacity)) throw new RuntimeException(INVALID_CAPACITY);
	}

	private static boolean isValidCapacity(Float aCapacity) {
		return aCapacity > 0 && aCapacity <= 20;
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
	
	public boolean hasDeliveredOrders() {
		return !this.getDeliveredOrders().isEmpty();
	}

}
