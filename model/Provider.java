package model;

import java.util.ArrayList;
import java.util.List;

public class Provider {
	private String name;
	private Integer cuil;
	private String adress;
	private Integer xCoordinate;
	private Integer yCoordinate;
	private final  List<Order> preparedOrders;
	
	
	private Provider(String aName, Integer aCuil, String anAdress, Integer aXCoordinate, Integer aYCoordinate ) {
		name = aName;
		cuil = aCuil;
		adress = anAdress;
		xCoordinate = aXCoordinate;
		yCoordinate = aYCoordinate;
		preparedOrders = new ArrayList<Order>();
	}
	
	public void prepareOrder(Order orderToBePrepared) {
		
	}
	
	public void rejectOrder(Order orderToBeRejected) {
		
	}
	
}
