package model.user;

import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;

public abstract class User {
	private static final String INVALID_USER_NAME = "Se debe completar el nombre de usuario";
	private static final String INVALID_PASS = "La contraseña debe contener al menos un caracter especial";
	private static final String INVALID_EMAIL = "El email debe conterner el caracter '@' ";
	private static final String INVALID_BIRTHDAY = "El usuario debe ser mayor de edad ";
	private static final String INVALID_NAME = "Se debe completar el nombre";
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
	
	protected static void assertIsValidUserName(String anUserName) {
		if(!isValidName(anUserName)) throw new RuntimeException(INVALID_USER_NAME);
	}

	private static boolean isValidName(String anUserName) {
		return !anUserName.isBlank();
	}
	
	protected static void assertIsValidPass(String aPass) {
		if (!isValidPass(aPass)) throw new RuntimeException(INVALID_PASS);
	}

	private static boolean isValidPass(String aPass) {
		return checkSpecialChars(aPass);
	}
	
	private static boolean checkSpecialChars(String aPass) {
		String specialChars = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		boolean check = false;
		
		for (int i = 0; i < aPass.length(); i++) {
			String strChar = Character.toString(aPass.charAt(i));

			if (specialChars.contains(strChar)) {
				check = true;
				break;
			}
		}

		return check;
	}	

	protected static void assertIsValidName(String aName) {
		if(!isValidName(aName)) throw new RuntimeException(INVALID_NAME);
	}	
	
	protected static void assertIsValidEmail(String anEmail) {
		if(!isValidEmail(anEmail)) throw new RuntimeException(INVALID_EMAIL);
	}

	private static boolean isValidEmail(String anEmail) {
		return anEmail.contains("@");
	}

	protected static void assertIsvalidBirthday(LocalDate aBirthday) {
		if(!isValidBirthday(aBirthday)) throw new RuntimeException(INVALID_BIRTHDAY);
	}

	private static boolean isValidBirthday(LocalDate aBirthday) {
		return aBirthday.isAfter(LocalDate.of(1890, 1, 1) ) && 
			aBirthday.isBefore(LocalDate.now().minusYears(18));
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
