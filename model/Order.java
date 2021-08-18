package model;

public class Order {
	private final Integer orderNumber;
	private final Integer quantity;
	private final User customer;
	private final Product product;
	private OrderState state;
	
	//Se instancian de manera provisoria los estados dentro de la orden hasta contar con una clase 
	//"sistema" que administre todos los objetos en ella
	OrderState pendingState = new PendingState();
	OrderState preparedState = new PreparedState();
	OrderState arrivedState = new ArrivedState();
	OrderState cancelState = new CancelState();

	private Order(Integer anOrderNumber, Integer aQuantity, User aCustomer, Product aProduct ) {
		orderNumber = anOrderNumber;
		quantity = aQuantity;
		customer = aCustomer;
		product = aProduct;
		state = pendingState;
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
	
	public void getCancel(){
		state.getCancel(this);
	}
	
	public void getPrepare() {
		state.getPrepare(this);
	}
	
	public void getArrive() {
		state.getArrive(this);
	}

	//El modificador de visibilidad seria preferentemente como de paquete para que no se pueda setear un 
	//estado que no corresponda (solo sea visible para la orden y sus estados)
	public void setOrderState(OrderState newOrderState) {
		state = newOrderState;
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
