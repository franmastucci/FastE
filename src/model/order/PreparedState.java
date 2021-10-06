package model.order;

public class PreparedState extends OrderStateFactory {
	
	private String CANT_BE_PREPARED = "La orden no puede ser preparada porque esta en estado " + this.getName();
	private String CANT_BE_CANCEL = "La orden no puede ser cancelada porque esta en estado " + this.getName();
	
	//constructor temporalmente con modificador publico, evaluar si el alcance es de paquete
	protected PreparedState() {
		super("Preparado") ;
	}

	@Override
	public void getPrepare(Order anOrder) {
		throw new RuntimeException(CANT_BE_PREPARED);
	}

	@Override
	public void getArrive(Order anOrder) {
		anOrder.updateLastModify();
		anOrder.setState(super.getArrivedState());
	}

	@Override
	public void getCancel(Order anOrder) {
		throw new RuntimeException(CANT_BE_CANCEL);
	}

	@Override
	protected boolean isPending() {
		return false;
	}

	@Override
	protected boolean isPrepared() {
		return true;
	}

	@Override
	protected boolean isCancel() {
		return false;
	}

	@Override
	protected boolean isArrived() {
		return false;
	}
}
