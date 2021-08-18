package model;

import java.time.LocalDate;

public abstract class User {
	
	protected String userName;
	protected String pass;
	protected String name;
	protected String email;
	protected LocalDate birthday;
	
	public abstract User register(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday);

	public String getUserName() {
		return userName;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthDay() {
		return birthday;
	}
	
}
