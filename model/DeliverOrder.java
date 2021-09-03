package model;

public class DeliverOrder {
	private long id;
	private Order order;
	private User delivery;
	
	private DeliverOrder() {};
	
	private DeliverOrder(long anId, Order anOrder, User aDelivery) {
		id = anId;
		order = anOrder;
		delivery = aDelivery;
	}

	private DeliverOrder(Order anOrder, User aDelivery) {
		order = anOrder;
		delivery = aDelivery;
	};
	
	public static DeliverOrder doneOrderDeliver(Order anOrder, User aDelivery) {
		return new DeliverOrder(anOrder, aDelivery);
	}
	
	public long getId() {
		return id;
	}
	
	private void setId(long id) {
		this.id = id;
	}
	
	public Order getOrder() {
		return order;
	}
	
	private void setOrder(Order order) {
		this.order = order;
	}
	
	public User getDelivery() {
		return delivery;
	}
	
	private void setDelivery(User delivery) {
		this.delivery = delivery;
	}
	
}
