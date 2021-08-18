package model;

public class Order {
	private final Integer orderNumber;
	private final Integer quantity;
	private final User customer;
	private final Product product;
	
	private Order(Integer anOrderNumber, Integer aQuantity, User aCustomer, Product aProduct ) {
		orderNumber = anOrderNumber;
		quantity = aQuantity;
		customer = aCustomer;
		product = aProduct;
	}
	
	public static Order newOrder(Integer anOrderNumber, Integer aQuantity, User aCustomer, Product aProduct) {
		return new Order(anOrderNumber, aQuantity, aCustomer, aProduct);
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public User getCustomer() {
		return customer;
	}

	public Product getProduct() {
		return product;
	}

}
