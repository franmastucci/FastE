package model.order;

public class CancelState extends OrderStateFactory {
	
	private String CANT_BE_PREPARED = "La orden no puede ser preparada porque esta en estado " + this.getName();
	private String CANT_BE_ARRIVED = "La orden no puede ser entregada porque esta en estado " + this.getName();
	private String CANT_BE_CANCEL = "La orden no puede ser cancelada porque esta en estado " + this.getName();

	
	//constructor temporalmente con modificador publico, evaluar si el alcance es de paquete
	protected CancelState() {
		super("Cancelado");
	}
	
	@Override
	public void getPrepare(Order anOrder) {
		throw new RuntimeException(CANT_BE_PREPARED);
	}

	@Override
	public void getArrive(Order anOrder) {
		throw new RuntimeException(CANT_BE_ARRIVED);
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
		return false;
	}

	@Override
	protected boolean isCancel() {
		return true;
	}

	@Override
	protected boolean isArrived() {
		return false;
	}
}
