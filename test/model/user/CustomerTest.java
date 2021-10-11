package model.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;
import model.provider.Provider;

class CustomerTest extends UserTest{

	@BeforeEach
	public void setup() {
		this.juan = Customer.register("Juan ", "prueba_", "CUstomer ", "customer@gmail.com ", LocalDate.of(1988, 8, 1));
		this.cocaCola = Provider.register(20122334459l, "coca-cola","Av donato Alvarez 123", 20,30);
		this.coca = Product.publishProduct("Coca", cocaCola, 20f, 15f);
	}
	
	@Test
	public void testUserNameCanNotBeBlank() {
		assertThrows(RuntimeException.class, ()->Customer.register(" ", " prueba_", " Customer " , "customer@gmail.com", LocalDate.of(1988, 8, 1)));
	}
	
	@Test
	public void testUserHasAValidPass() {
		assertThrows(RuntimeException.class, ()->Customer.register("Juan", "  ", " Customer " , "customer@gmail.com", LocalDate.of(1988, 8, 1)));
	}

	@Test
	public void testUserHasAValidName() {
		assertThrows(RuntimeException.class, ()->Customer.register(" Juan ", "prueba_", "  " , "customer@gmail.com", LocalDate.of(1988, 8, 1)));
	}
	@Test
	public void testUserHasAValidEmail() {
		assertThrows(RuntimeException.class, ()->Customer.register("Juan ", "prueba_", "CUstomer ", " ", LocalDate.of(1988, 8, 1)));
	}
	
	@Test
	public void testUserHasAValidBirthday() {
		assertThrows(RuntimeException.class, ()->Customer.register("Juan ", "prueba_", "CUstomer ", "customer@gmail.com ", LocalDate.of(1888, 8, 1)));
	}
	
	@Test
	public void testNewCustomerHasNotMadeAnOrder() {
		assertFalse(juan.hasMadeAnOrder());
	}
	
	@Test
	public void testCustomerHasMadeAnOrder() {
		anOrder = juan.makeAnOrder(coca, 3);
		assertTrue(juan.hasMadeAnOrder());
	}
	
}
