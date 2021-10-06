package model.order;

public abstract class OrderStateFactory {

	private String name;
	private final static PendingState pendingState = new PendingState();
	private final static PreparedState preparedState = new PreparedState();
	private final static ArrivedState arrivedState = new ArrivedState();
	private final static CancelState cancelState = new CancelState();
	
	public OrderStateFactory(String anStateName) {
		this.name = anStateName;
	}
	
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

	public abstract void getPrepare(Order anOrder) ;
	
	public abstract void getArrive(Order anOrder) ;
	
	public abstract void getCancel(Order anOrder) ;

	protected abstract boolean isPending();

	protected abstract boolean isPrepared();

	protected abstract boolean isCancel();

	protected abstract boolean isArrived();
}
