package model;

public class Provider {
	private String name;
	private Integer cuil;
	private String adress; // se podria implimentar una clase "direcci�n" que contenga las coordenadas X e Y"
	private Integer xCoordinate;
	private Integer yCoordinate;
	//private List<Order> ordersToDispatch;
	
	private Provider() {};
	
	public static Provider register(String aName, Integer aCuil, String anAdress, Integer aXCoordinate, Integer aYCoordinate) {
        Provider newProvider = new Provider();
        newProvider.setName(aName);
        newProvider.setCuil(aCuil);
        newProvider.setAdress(anAdress);
        newProvider.setxCoordinate(aXCoordinate);
        newProvider.setyCoordinate(aYCoordinate);
        return newProvider;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Integer getCuil() {
		return cuil;
	}

	private void setCuil(Integer cuil) {
		this.cuil = cuil;
	}

	public String getAdress() {
		return adress;
	}

	private void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	private void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	private void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

}
