package model;

public abstract class OrderState {

	protected String name;
	
	//se declaran los mensajes de error para las subclases lanzados como runtimeException. Sujeto a modificacion 
	//en caso de ser necesario
	protected String CANT_BE_PREPARED = "La orden no puede ser preparada porque esta en estado " + this.getName();
	protected String CANT_BE_ARRIVED = "La orden no puede ser entregada porque esta en estado " + this.getName();
	protected String CANT_BE_CANCEL = "La orden no puede ser cancelada porque esta en estado " + this.getName();
	
	protected String getName() {
		return name;
	}
	
	public abstract void getPrepare(Order anOrder);
	
	public abstract void getArrive(Order anOrder);
	
	public abstract void getCancel(Order anOrder);
}
