package model.order;

public interface State {

	public void getPrepare(Order anOrder);
	
	public void getArrive(Order anOrder);
	
	public void getCancel(Order anOrder);

}
