package model;

public class Order {
	private long orderNumber;
	private Integer quantity;
	private User customer;
	private Product product;
	private OrderState state;
	
	//Se instancian de manera provisoria los estados dentro de la orden hasta contar con una clase 
	//"sistema" que administre todos los objetos en ella
	OrderState pendingState = new PendingState();
	OrderState preparedState = new PreparedState();
	OrderState arrivedState = new ArrivedState();
	OrderState cancelState = new CancelState();

	private Order() {}
	
	public static Order newOrder(Integer aQuantity, User aCustomer, Product aProduct) {
		Order newOrder = new Order();
		newOrder.setQuantity(aQuantity);
		newOrder.setCustomer(aCustomer);
		newOrder.setProduct(aProduct);
		newOrder.setState(newOrder.getPendingState());
		return newOrder;
	}
	
	public long getOrderNumber() {
		return orderNumber;
	}

	private void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	private void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public User getCustomer() {
		return customer;
	}
	
	private void setCustomer(User customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}
	
	private void setProduct(Product product) {
		this.product = product;
	}

	public OrderState getState() {
		return state;
	}

	void setState(OrderState state) {
		this.state = state;
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

	public OrderState getPendingState() {
		return pendingState;
	}
	
	public OrderState getCancelState() {
		return cancelState;
	}

	public OrderState getPreparedState() {
		return preparedState;
	}

	public OrderState getArrivedState() {
		return arrivedState;
	}
	
}
