package model;

public class PreparedState extends OrderState {
	
	//constructor temporalmente con modificador publico, evaluar si el alcance es de paquete
	public PreparedState() {
		name = "Preparado";
	}

	@Override
	public void getPrepare(Order anOrder) {
		throw new RuntimeException(CANT_BE_PREPARED);
	}

	@Override
	public void getArrive(Order anOrder) {
		anOrder.setState(anOrder.getArrivedState());
	}

	@Override
	public void getCancel(Order anOrder) {
		throw new RuntimeException(CANT_BE_CANCEL);
	}
}
