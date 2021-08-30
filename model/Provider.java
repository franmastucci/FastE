package model;

import java.util.ArrayList;
import java.util.List;

public class Provider {
	private final String name;
	private final Integer cuil;
	private String adress; // se podria implimentar una clase "direcci�n" que contenga las coordenadas X e Y"
	private Integer xCoordinate;
	private Integer yCoordinate;
	private final  List<Order> ordersToDispatch;
	
	
	private Provider(String aName, Integer aCuil, String anAdress, Integer aXCoordinate, Integer aYCoordinate ) {
		name = aName;
		cuil = aCuil;
		adress = anAdress;
		xCoordinate = aXCoordinate;
		yCoordinate = aYCoordinate;
		ordersToDispatch = new ArrayList<Order>();
	}
	
	public static Provider register(String aName, Integer aCuil, String anAdress, Integer aXCoordinate, Integer aYCoordinate) {
		return new Provider(aName, aCuil, anAdress, aXCoordinate, aYCoordinate);
	}

	public String getName() {
		return name;
	}

	public Integer getCuil() {
		return cuil;
	}

	public String getAdress() {
		return adress;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	public List<Order> getOrdersToDispatch() {
		return ordersToDispatch;
	}

}
