package model.order;

import java.time.LocalDate;

import model.provider.Product;
import model.user.User;

public class Order {
	private long orderNumber;
	private User customer;
	private Product product;
	private Float unitaryPrice;
	private Integer quantity;
	private State state;
	private LocalDate creationDate;
	private LocalDate lastStateModification;

	private Order() {}

	private Order(long anOrderNumber, User aCustomer, Product aProduct, Integer aQuantity, State anOrderState,
			LocalDate aCreationDate, LocalDate aModificationDate, Float anUnitaryPrice ) {
		this.orderNumber = anOrderNumber;
		this.customer = aCustomer;
		this.product = aProduct;
		this.unitaryPrice = anUnitaryPrice;
		this.quantity = aQuantity;
		this.state = anOrderState;
		this.creationDate = aCreationDate;
		this.lastStateModification = aModificationDate;
	}

	private Order(User aCustomer, Product aProduct, Integer aQuantity) {
		this.customer = aCustomer;
		this.product = aProduct;
		this.unitaryPrice = aProduct.getPrice().getValue();
		this.quantity = aQuantity;
		this.state = OrderState.PENDING;
		this.creationDate = LocalDate.now();
		this.lastStateModification = LocalDate.now();
	}

	public static Order newOrder(User aCustomer, Product aProduct, Integer aQuantity) {
		return new Order(aCustomer, aProduct, aQuantity);
	}
	
	public Float getTotalCost() {
        return this.getUnitaryPrice() * this.getQuantity();
    }
	
	public long getOrderNumber() {
		return orderNumber;
	}

	@SuppressWarnings("unused")
	private void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	@SuppressWarnings("unused")
	private void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public User getCustomer() {
		return customer;
	}
	
	@SuppressWarnings("unused")
	private void setCustomer(User customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}
	
	@SuppressWarnings("unused")
	private void setProduct(Product product) {
		this.product = product;
	}
	
	public float getUnitaryPrice() {
		return unitaryPrice;
	}
	
	public void setUnitaryPrice(Float unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public State getState() {
		return state;
	}

	void setState(State state) {
		this.state = state;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}

	@SuppressWarnings("unused")
	private void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getLastStateModification() {
		return lastStateModification;
	}
	
	private void setLastStateModification(LocalDate lastStateModifycation) {
		this.lastStateModification = lastStateModifycation;
	}

	public void getCancel(){
		this.state.getCancel(this);
	}

	public void getPrepare() {
		this.state.getPrepare(this);
	}
	
	public void getArrive() {
		this.state.getArrive(this);
	}

	void updateLastModify() {
		LocalDate today = LocalDate.now();
		this.setLastStateModification(today);
	}

//	public OrderState getPendingState() {
//		return pendingState;
//	}
//	
//	public OrderState getCancelState() {
//		return cancelState;
//	}
//
//	public OrderState getPreparedState() {
//		return preparedState;
//	}
//
//	public OrderState getArrivedState() {
//		return arrivedState;
//	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", customer=" + customer + ", product=" + product + ", quantity="
				+ quantity + ", state=" + state + "]";
	}

	
}
