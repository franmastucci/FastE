package model.order;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cancel")
public class CancelState extends OrderStateFactory {
		
	//constructor temporalmente con modificador publico, evaluar si el alcance es de paquete
	protected CancelState() {
		super("Cancelado");
	}
	
	@Override
	public void getPrepare(Order anOrder) {
		throw new RuntimeException(CANT_BE_PREPARED + this.getName());
	}

	@Override
	public void getArrive(Order anOrder) {
		throw new RuntimeException(CANT_BE_ARRIVED + this.getName());
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
