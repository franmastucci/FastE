package model.provider;

import org.springframework.stereotype.Component;

@Component
public class Provider {
	private static final String INVALID_CUIL = "El cuil debe ser un valor entre 20000000001 y 21000000000";
	private static final String INVALID_NAME = "El nombre no puede estar en blanco";
	private static final String INVALID_ADDRESS = "La dirección no puede estar en blanco";
	private Long cuil;
	private String name;
	private String adress; // se podria implimentar una clase "direcciï¿½n" que contenga las coordenadas X e Y"
	private Integer xCoordinate;
	private Integer yCoordinate;
	
	
	private Provider() {};
	
	private Provider(Long aCuil, String aName, String anAdress, Integer aXCoordinate, Integer aYCoordinate) {
		this.cuil = aCuil;
		this.name = aName;
		this.adress = anAdress;
		this.xCoordinate = aXCoordinate;
		this.yCoordinate = aYCoordinate;
	}

	//Metodo de acceso publico para crear instancias de Provider
	public static Provider register(Long aCuil, String aName, String anAdress, Integer aXCoordinate, Integer aYCoordinate) {
        
		assertIsValidCuil(aCuil);
		assertIsValidName(aName);
		assertIsValidAddress(anAdress);
		return new Provider(aCuil, aName, anAdress, aXCoordinate, aYCoordinate);
	}

	private static void assertIsValidAddress(String anAdress) {
		if(!isValidEntry(anAdress)) throw new RuntimeException(INVALID_ADDRESS);
	}

	private static void assertIsValidName(String aName) {
		if(!isValidEntry(aName)) throw new RuntimeException(INVALID_NAME);
	}
	
	//Se llama isValidEntry provisoriamente porque aplica tanto  para la dirección como
	//para el nombre, dado que se busca validar que el String no esté en blanco
	private static boolean isValidEntry(String anEntry) {
		return !anEntry.isBlank();
	}

	private static void assertIsValidCuil(Long aCuil) {
		if(!isValidCuil(aCuil)) throw new RuntimeException(INVALID_CUIL);
	}

	private static boolean isValidCuil(Long aCuil) {
		return aCuil > 20000000000l && aCuil < 21000000000l;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("unused")
	private void setName(String name) {
		this.name = name;
	}

	public Long getCuil() {
		return cuil;
	}

	@SuppressWarnings("unused")
	private void setCuil(Long cuil) {
		this.cuil = cuil;
	}

	public String getAdress() {
		return adress;
	}

	@SuppressWarnings("unused")
	private void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	@SuppressWarnings("unused")
	private void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	@SuppressWarnings("unused")
	private void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	@Override
	public String toString() {
		return "Provider [cuil=" + cuil + ", name=" + name + ", adress=" + adress + ", xCoordinate=" + xCoordinate
				+ ", yCoordinate=" + yCoordinate + "]";
	}

}
