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

	public void setUserName(String anUserName) {
		this.userName = anUserName;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String aPass) {
		this.pass = aPass;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String aName) {
		this.name = aName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String anEMail) {
		this.email = anEMail;
	}
	
	public LocalDate getBirthDay() {
		return birthday;
	}

	public void setBirthday(LocalDate aDate) {
		this.birthday = aDate;
	}

	
}
