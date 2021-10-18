package model.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		this.userName = anUserName;
		this.pass = aPass;
		this.name = aName;
		this.email = anEmail;
		this.birthday = aBirthday;
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

		List<Character> specialCharList = new ArrayList<>(specialChars.chars().mapToObj(e -> (char) e)
				.collect(Collectors.toList()));
		List<Character> passChar = new ArrayList<>(aPass.chars().mapToObj(e -> (char) e)
				.collect(Collectors.toList()));

		List<Character> result = specialCharList.stream().filter(charact -> passChar.contains(charact))
				.collect(Collectors.toList());
		
		return !result.isEmpty();
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
		return this.userName;
	}

	protected void setUserName(String anUserName) {
		this.userName = anUserName;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	protected void setPass(String aPass) {
		this.pass = aPass;
	}

	public String getName() {
		return this.name;
	}
	
	protected void setName(String aName) {
		this.name = aName;
	}

	public String getEmail() {
		return this.email;
	}

	protected void setEmail(String anEMail) {
		this.email = anEMail;
	}
	
	public LocalDate getBirthday() {
		return this.birthday;
	}

	protected void setBirthday(LocalDate aDate) {
		this.birthday = aDate;
	}

	@Override
	public String toString() {
		return "User [userName=" + this.userName + ", name=" + this.name + ", email=" + this.email + 
				", birthday=" + this.birthday + "]";
	}

}
