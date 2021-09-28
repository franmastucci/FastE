package model.user;

import static org.junit.Assert.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
	
	private User customerTest;
	
	@BeforeEach
	public void setup() {
		customerTest = Customer.register("customerTest", "prueba", "Customer", "customer@email.com",
			LocalDate.of(1988, 8, 1));
	}
	
	@Test
	public void anUserHasANotEmptyUserName() {
		assertFalse(customerTest.getUserName().isBlank());
	}
	
}
