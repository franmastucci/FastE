package model.order;

public interface OrderState {

	public abstract void getPrepare(Order anOrder) ;
	
	public abstract void getArrive(Order anOrder) ;
	
	public abstract void getCancel(Order anOrder) ;

}
