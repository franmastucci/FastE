package model;

public class Provider {
	private Integer cuil;
	private String name;
	private String adress; // se podria implimentar una clase "direcci�n" que contenga las coordenadas X e Y"
	private Integer xCoordinate;
	private Integer yCoordinate;
	
	private Provider() {};
	
	private Provider(Integer aCuil, String aName, String anAdress, Integer aXCoordinate, Integer aYCoordinate) {
		cuil = aCuil;
		name = aName;
		adress = anAdress;
		xCoordinate = aXCoordinate;
		yCoordinate = aYCoordinate;
	}

	//Metodo de acceso publico para crear instancias de Provider
	public static Provider register(Integer aCuil, String aName, String anAdress, Integer aXCoordinate, Integer aYCoordinate) {
        return new Provider(aCuil, aName, anAdress, aXCoordinate, aYCoordinate);
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
