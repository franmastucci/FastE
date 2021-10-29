package model.order;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="state",discriminatorType=DiscriminatorType.STRING)
public abstract class OrderStateFactory {

	protected String CANT_BE_PREPARED = "La orden no puede ser preparada porque esta en estado ";
	protected String CANT_BE_ARRIVED = "La orden no puede ser entregada porque esta en estado ";
	protected String CANT_BE_CANCEL = "La orden no puede ser cancelada porque esta en estado ";	
	@Id
	private String name;
	private final static PendingState pendingState = new PendingState();
	private final static PreparedState preparedState = new PreparedState();
	private final static ArrivedState arrivedState = new ArrivedState();
	private final static CancelState cancelState = new CancelState();
	
	public OrderStateFactory(String anStateName) {
		this.name = anStateName;
	}
	
	public String getName() {
		return this.name;
	}
	
	protected void setName(String aName) {
		this.name = aName;
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
		return this.name;
	}

	public abstract void getPrepare(Order anOrder) ;
	
	public abstract void getArrive(Order anOrder) ;
	
	public abstract void getCancel(Order anOrder) ;

	protected abstract boolean isPending();

	protected abstract boolean isPrepared();

	protected abstract boolean isCancel();

	protected abstract boolean isArrived();
}
