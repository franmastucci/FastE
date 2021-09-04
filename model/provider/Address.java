package model.provider;

public class Address {
	private long id;
    private String streetName;
    private String number; 
	private Integer xCoordinate;
	private Integer yCoordinate;
    
    private Address() {}

    private Address (long anId, String aStreetName, String aNumber, Integer aXCoordinate, Integer aYCoordinate) {
        id = anId;
        streetName = aStreetName;
        number = aNumber;
        xCoordinate = aXCoordinate;
        yCoordinate = aYCoordinate;
    }

    public static Address registerAddress(long anId, String aStreetName, String aNumber, Integer aXCoordinate, Integer aYCoordinate) {  
        return new Address(anId, aStreetName, aNumber , aXCoordinate, aYCoordinate);       
    }

    public long getId () {
		return id;
	}

	private void setId(long anId) {
		this.id = anId;
	}

    public String getStreetName() {
		return streetName;
	}

	private void setStreetName(String aStreetName) {
		this.streetName = aStreetName;
	}
    
    public String getNumber() {
		return number;
	}

	private void setNumber(String aNumber) {
		this.number = aNumber;
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
