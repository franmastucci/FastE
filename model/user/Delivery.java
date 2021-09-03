package model.user;

import java.time.LocalDate;

public class Delivery extends User {
	
	private Float capacity;
//	private List<Order> takenOrders;
	
	private Delivery() {}
	
	//Constructor creado para cumplir con requerimientos de Hibernate
	private Delivery(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday, Float aCapacity) {
		userName = anUserName;
		pass = aPass;
		name = aName;
		email = anEmail;
		birthday = aBirthday;
		capacity = aCapacity;
	}

	//Metodo de acceso publico para crear instancias de Delivery
	public static Delivery register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday, Float aCapacity) {
		return new Delivery(anUserName, aPass, aName, anEmail, aBirthday, aCapacity);
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
