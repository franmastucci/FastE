package model.user;

import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;

public abstract class User {
	
	protected String userName;
	protected String pass;
	protected String name;
	protected String email;
	protected LocalDate birthday;

	protected User() {};
	
	protected User(String anUserName, String aPass, String aName, String anEmail, LocalDate aBirthday) {
		String encryptedPass = DigestUtils.sha1Hex(aPass);
		userName = anUserName;
		pass = encryptedPass;
		name = aName;
		email = anEmail;
		birthday = aBirthday;
	}
	
	public String getUserName() {
		return userName;
	}

	protected void setUserName(String anUserName) {
		this.userName = anUserName;
	}
	
	public String getPass() {
		return pass;
	}
	
	protected void setPass(String aPass) {
		this.pass = aPass;
	}

	public String getName() {
		return name;
	}
	
	protected void setName(String aName) {
		this.name = aName;
	}

	public String getEmail() {
		return email;
	}

	protected void setEmail(String anEMail) {
		this.email = anEMail;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}

	protected void setBirthday(LocalDate aDate) {
		this.birthday = aDate;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", email=" + email + ", birthday=" + birthday + "]";
	}

}
