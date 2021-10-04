package model.order;

public class PreparedState extends OrderStateFactory implements State{
	
	//constructor temporalmente con modificador publico, evaluar si el alcance es de paquete
	public PreparedState() {
		this.name = "Preparado";
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
}
