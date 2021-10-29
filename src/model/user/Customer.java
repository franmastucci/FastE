package model.user;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

import model.order.Order;
import model.provider.Product;
@Entity
@DiscriminatorValue("Customer")
public class Customer extends User {
	@OneToMany
	private List<Order> ordersStory;
	
	@SuppressWarnings("unused")
	private Customer() {}

	//Requerido por hibernate
	protected Customer(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday, 
			List<Order>	anOrdersStoryList) {
		
		super(anUserName, aPass, aName, anEmail, aBirthday);
		this.ordersStory = anOrdersStoryList;
	}

	//Metodo de acceso publico para crear instancias de Customer
	public static Customer register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		
		assertIsValidUserName(anUserName);
		assertIsValidPass(aPass);
		assertIsValidName(aName);
		assertIsValidEmail(anEmail);
		assertIsvalidBirthday(aBirthday);
		
		List<Order> anOrdersStory = new ArrayList<Order>();
		return new Customer(anUserName, aPass, aName, anEmail, aBirthday, anOrdersStory);
	}
	

	public List<Order> getOrdersStory() {
		return this.ordersStory;
	}
	
	@SuppressWarnings("unused")
	private void setOrdersStory(List<Order> anOrderList) {
		this.ordersStory = anOrderList;
	}

	public Order makeAnOrder(Product aProduct, Integer aQuantity) {
		Order newOrder = Order.newOrder(this, aProduct, aQuantity);
		this.getOrdersStory().add(newOrder);
		return newOrder;
	}
	
	
	@Override
	public String toString() {
		return "Customer [username=" + this.userName+ ", name=" + this.name+ ", email=" + this.email+ "]";
	}

	public boolean hasMadeAnOrder() {
		return !this.getOrdersStory().isEmpty();
	}

}