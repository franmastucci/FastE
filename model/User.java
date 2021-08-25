package model;

import java.time.LocalDate;

public abstract class User {
	
	protected String userName;
	protected String pass;
	protected String name;
	protected String email;
	protected LocalDate birthday;

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
