package model.order;

public abstract class OrderStateImpl {

	protected String name;
	public final static PendingState pendingState = new PendingState();
	public final static PreparedState preparedState = new PreparedState();
	public final static ArrivedState arrivedState = new ArrivedState();
	public final static CancelState cancelState = new CancelState();
	
	//se declaran los mensajes de error para las subclases lanzados como runtimeException. Sujeto a modificacion 
	//en caso de ser necesario
	protected String CANT_BE_PREPARED = "La orden no puede ser preparada porque esta en estado " + this.getName();
	protected String CANT_BE_ARRIVED = "La orden no puede ser entregada porque esta en estado " + this.getName();
	protected String CANT_BE_CANCEL = "La orden no puede ser cancelada porque esta en estado " + this.getName();
	
	public String getName() {
		return name;
	}
	
	protected void setName(String aName) {
		name = aName;
	}
	
	public static PendingState getPendingState() {
		return pendingState;
	}

	public static PreparedState getPreparedState() {
		return preparedState;
	}

	public static ArrivedState getArrivedState() {
		return arrivedState;
	}

	public static CancelState getCancelState() {
		return cancelState;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
