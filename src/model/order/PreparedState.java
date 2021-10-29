package model.order;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Prepared")
public class PreparedState extends OrderStateFactory {
	
	//constructor temporalmente con modificador publico, evaluar si el alcance es de paquete
	protected PreparedState() {
		super("Preparado") ;
	}

	@Override
	public void getPrepare(Order anOrder) {
		throw new RuntimeException(CANT_BE_PREPARED + this.getName());
	}

	@Override
	public void getArrive(Order anOrder) {
		anOrder.updateLastModify();
		anOrder.setState(super.getArrivedState());
	}

	@Override
	public void getCancel(Order anOrder) {
		throw new RuntimeException(CANT_BE_CANCEL + this.getName());
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
