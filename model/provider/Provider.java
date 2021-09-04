package model.provider;

public class Provider {
	private Integer cuil;
	private String name;
	private Address address;
	
	private Provider() {};
	
	private Provider(Integer aCuil, String aName, Address anAddress) {
		cuil = aCuil;
		name = aName;
		address = anAddress;
	}

	//Metodo de acceso publico para crear instancias de Provider
	public static Provider register(Integer aCuil, String aName, Address anAddress) {
        return new Provider(aCuil, aName, anAddress);
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

	public Address getAddress() {
		return address;
	}

	private void setAddress(Address address) {
		this.address = address;
	}
}