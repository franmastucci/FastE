package model;

import java.time.LocalDate;

public class Delivery extends User {
	
	private Float capacity;
//	private List<Order> takenOrders;
	
	private Delivery() {}
	
	//el m�todo de clase "register" est� pensado para realizar las validaciones antes de construir una instancia de
	// "Delivery" y para evitar que el contructor sea de acceso p�blico
	public static Delivery register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday, Float aCapacity) {
		Delivery newDelivery = new Delivery();
		newDelivery.setUserName(anUserName);
		newDelivery.setPass(aPass);
		newDelivery.setName(aName);
		newDelivery.setEmail(anEmail);
		newDelivery.setBirthday(aBirthday);
		newDelivery.setCapacity(aCapacity);
		return newDelivery;
	}
	
	public Float getCapacity() {
		return capacity;
	}
	
	private void setCapacity(Float aCapacity) {
		this.capacity = aCapacity;
	}	

//	public List<Order> getTakenOrders() {
//		return takenOrders;
//	}
	
}
