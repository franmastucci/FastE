package model.order;

import java.time.LocalDate;
import model.provider.Product;
import model.user.User;

public class Order {
	private static final String INVALID_CUSTOMER = "El cliente no puede ser nulo";
	private static final String INVALID_PRODUCT = "El producto no puede ser nulo";
	private static final String INVALID_QUANTITY = "La cantidad debe ser un valor psitivo";
	private long orderNumber;
	private User customer;
	private Product product;
	private Float unitaryPrice;
	private Integer quantity;
	private OrderStateFactory state;
	private LocalDate creationDate;
	private LocalDate lastStateModification;

	private Order() {}

	private Order(long anOrderNumber, User aCustomer, Product aProduct, Integer aQuantity, OrderStateFactory anOrderState,
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

	private  Order(User aCustomer, Product aProduct, Integer aQuantity) {
		this.customer = aCustomer;
		this.product = aProduct;
		this.unitaryPrice = aProduct.getPrice().getValue();
		this.quantity = aQuantity;
		this.state = OrderStateFactory.getPendingState();
		this.creationDate = LocalDate.now();
		this.lastStateModification = LocalDate.now();
	}

	public static Order newOrder(User aCustomer, Product aProduct, Integer aQuantity) {
		
		asserIsValidCustomer(aCustomer);
		assertIsValidProduct(aProduct);
		assertIsValidQuantity(aQuantity);
		
		return new Order(aCustomer, aProduct, aQuantity);
	}

	private static void assertIsValidQuantity(Integer aQuantity) {
		if(!isValidQuantity(aQuantity)) throw new RuntimeException(INVALID_QUANTITY);
	}

	private static boolean isValidQuantity(Integer aQuantity) {
		return aQuantity > 0;
	}

	private static void assertIsValidProduct(Product aProduct) {
		if(!isValidProduct(aProduct)) throw new RuntimeException(INVALID_PRODUCT);
	}

	private static boolean isValidProduct(Product aProduct) {
		return aProduct != null;
	}

	private static void asserIsValidCustomer(User aCustomer) {
		if(!isValidCustomer(aCustomer)) throw new RuntimeException(INVALID_CUSTOMER);
	}

	private static boolean isValidCustomer(User aCustomer) {
		return aCustomer != null;
	}
	
	public Float getTotalCost() {
        return this.getUnitaryPrice() * this.getQuantity();
    }
	
	public long getOrderNumber() {
		return this.orderNumber;
	}

	@SuppressWarnings("unused")
	private void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getQuantity() {
		return this.quantity;
	}
	
	@SuppressWarnings("unused")
	private void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public User getCustomer() {
		return this.customer;
	}
	
	@SuppressWarnings("unused")
	private void setCustomer(User customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return this.product;
	}
	
	public float getUnitaryPrice() {
		return this.unitaryPrice;
	}
	
	public void setUnitaryPrice(Float unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}
	
	@SuppressWarnings("unused")
	private void setProduct(Product product) {
		this.product = product;
	}

	public OrderStateFactory getState() {
		return this.state;
	}

	void setState(OrderStateFactory state) {
		this.state = state;
	}
	
	public LocalDate getCreationDate() {
		return this.creationDate;
	}

	@SuppressWarnings("unused")
	private void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getLastStateModification() {
		return this.lastStateModification;
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

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", customer=" + customer + ", product=" + product + ", quantity="
				+ quantity + ", state=" + state + "]";
	}

	public boolean isPending() {
		return this.getState().isPending();
		
	}

	public boolean isPrepared() {
		return this.getState().isPrepared();
	}

	public boolean isArrived() {	
		return this.getState().isArrived();
	}

	public boolean isCancel() {
		return this.getState().isCancel();
	}

}
