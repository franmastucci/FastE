package model;

public class Provider {
	private String name;
	private Integer cuil;
	private String adress; // se podria implimentar una clase "direcci�n" que contenga las coordenadas X e Y"
	private Integer xCoordinate;
	private Integer yCoordinate;
	//private List<Order> ordersToDispatch;
	
	
	public Provider(String aName, Integer aCuil, String anAdress, Integer aXCoordinate, Integer aYCoordinate ) {
		setName(aName);
		setCuil(aCuil);
		setAdress(anAdress);
		setxCoordinate(aXCoordinate);
		setyCoordinate(aYCoordinate);
		//ordersToDispatch = new ArrayList<Order>();
	}
	
	public static Provider register(String aName, Integer aCuil, String anAdress, Integer aXCoordinate, Integer aYCoordinate) {
		return new Provider(aName, aCuil, anAdress, aXCoordinate, aYCoordinate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCuil() {
		return cuil;
	}

	public void setCuil(Integer cuil) {
		this.cuil = cuil;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

}
