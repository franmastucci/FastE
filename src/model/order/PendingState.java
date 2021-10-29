package model.order;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Pending")
public class PendingState extends OrderStateFactory {
	
	//constructor temporalmente con modificador publico, evaluar si el alcance es de paquete
	 protected PendingState() {
		super("Pendiente");
	}
	
	@Override
	public void getPrepare(Order anOrder) {
		anOrder.updateLastModify();
		anOrder.setState(super.getPreparedState());
	}

	@Override
	public void getArrive(Order anOrder) {
		throw new RuntimeException(CANT_BE_ARRIVED + this.getName());
	}

	@Override
	public void getCancel(Order anOrder) {
		anOrder.updateLastModify();
		anOrder.setState(super.getCancelState());
	}

	@Override
	protected boolean isPending() {
		return true;
	}

	@Override
	protected boolean isPrepared() {
		return false;
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
