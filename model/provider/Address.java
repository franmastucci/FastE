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
    
    private Address (String aStreetName, String aNumber, Integer aXCoordinate, Integer aYCoordinate) {
        streetName = aStreetName;
        number = aNumber;
        xCoordinate = aXCoordinate;
        yCoordinate = aYCoordinate;
    }

    public static Address registerAddress( String aStreetName, String aNumber, Integer aXCoordinate, Integer aYCoordinate) {  
        return new Address(aStreetName, aNumber , aXCoordinate, aYCoordinate);       
    }

    public long getId () {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long anId) {
		this.id = anId;
	}

    public String getStreetName() {
		return streetName;
	}

	@SuppressWarnings("unused")
	private void setStreetName(String aStreetName) {
		this.streetName = aStreetName;
	}
    
    public String getNumber() {
		return number;
	}

	@SuppressWarnings("unused")
	private void setNumber(String aNumber) {
		this.number = aNumber;
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

}
