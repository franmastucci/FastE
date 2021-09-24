package model.order;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import model.provider.Product;
import model.user.User;

/**
 *  @implNote
 *  Se introducen las variables de instancia creationDate y lastStateModification a fines de poder obtener en la base de datos
 *  los los montos totales gastados por los clientes en determinadas fechas asi como las ordenes canceladas dias dias atras respecto
 *  a cuando se realiza la consulta
 */

@Component
public class Order {
	private long orderNumber;
	private User customer;
	private Product product;
	private Integer quantity;
	private OrderState state;
	private LocalDate creationDate;
	private LocalDate lastStateModification;
	
	OrderState pendingState = new PendingState();
	OrderState preparedState = new PreparedState();
	OrderState arrivedState = new ArrivedState();
	OrderState cancelState = new CancelState();

	public Order() {}

	/**
	 * @implNote
	 * Constructor creado para cumplir con requerimientos de Hibernate	
	 * @param anOrderNumber
	 * @param aCustomer
	 * @param aProduct
	 * @param aQuantity
	 * @param anOrderState
	 * @param aCreationDate
	 * @param aModificationDate
	 */
	public Order(long anOrderNumber, User aCustomer, Product aProduct, Integer aQuantity, OrderState anOrderState,
			LocalDate aCreationDate, LocalDate aModificationDate) {
		orderNumber = anOrderNumber;
		customer = aCustomer;
		product = aProduct;
		quantity = aQuantity;
		state = anOrderState;
		creationDate = aCreationDate;
		lastStateModification = aModificationDate;
	}

	public Order(User aCustomer, Product aProduct, Integer aQuantity) {
		customer = aCustomer;
		product = aProduct;
		quantity = aQuantity;
		state = this.getPendingState();
		creationDate = LocalDate.now();
		lastStateModification = LocalDate.now();
	}

	/**
	 * @implNote
	 * Metodo de acceso publico para crear instancias de Order	
	 * @param aCustomer
	 * @param aProduct
	 * @param aQuantity
	 * @return Order
	 */
	public static Order newOrder(User aCustomer, Product aProduct, Integer aQuantity) {
		return new Order(aCustomer, aProduct, aQuantity);
	}
	
	public Float getTotalCost() {
        return this.getProduct().getPrice().getValue() * this.getQuantity();
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

	public OrderState getState() {
		return state;
	}

	void setState(OrderState state) {
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

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", customer=" + customer + ", product=" + product + ", quantity="
				+ quantity + ", state=" + state + "]";
	}
	
}
