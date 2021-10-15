package model.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;
import model.provider.Provider;

class DeliveryTest extends UserTest{

	@BeforeEach
	public void setup() {
		this.cocaCola = Provider.register(20122334459l, "coca-cola","Av donato Alvarez 123", 20,30);
		this.coca = Product.publishProduct("Coca", cocaCola, 20f, 15f);
		this.juan = Customer.register("Juan ", "prueba_", "CUstomer ", "customer@gmail.com ", LocalDate.of(1988, 8, 1));
		this.newUser = Delivery.register("newUserUsername", "123@45", "newUser", "pepe@gmail.com", LocalDate.of(1988, 8, 1), 15f);
	}
	
	@Test
	public void testDliveryHasCapacityMoreThanZero() {
		assertThrows(RuntimeException.class, ()->Delivery.register("Juan", "prueba_", "Delivery", "delivery@gmail.com",  LocalDate.of(1988, 8, 1), -1f )); 
	}
	
	@Test
	public void testDliveryHasCapacityLessThanTwenty() {
		assertThrows(RuntimeException.class, ()->Delivery.register("Juan", "prueba_", "Delivery", "delivery@gmail.com",  LocalDate.of(1988, 8, 1), 25f )); 
	}
		
	@Test
	public void testUserNameCanNotBeBlank() {
		assertThrows(RuntimeException.class, ()->Delivery.register(" ", " prueba_", " Delivery " , "delivery@gmail.com", LocalDate.of(1988, 8, 1), 15f ));
	}
	
	@Test
	public void testUserHasAValidPass() {
		assertThrows(RuntimeException.class, ()->Delivery.register("Juan", "  ", " Delivery " , "delivery@gmail.com", LocalDate.of(1988, 8, 1), 15f ));
	}

	@Test
	public void testUserHasAValidName() {
		assertThrows(RuntimeException.class, ()->Delivery.register(" Juan ", "prueba_", "  " , "delivery@gmail.com", LocalDate.of(1988, 8, 1), 15f ));
	}
	@Test
	public void testUserHasAValidEmail() {
		assertThrows(RuntimeException.class, ()->Delivery.register("Juan ", "prueba_", "CUstomer ", " ", LocalDate.of(1988, 8, 1), 15f ));
	}
	
	@Test
	public void testUserHasAValidBirthday() {
		assertThrows(RuntimeException.class, ()->Delivery.register("Juan ", "prueba_", "CUstomer ", "delivery@gmail.com", LocalDate.of(1888, 8, 1), 15f ));
	}
	
	@Test void testGetCapacity() {
		assertEquals(((Delivery) this.newUser).getCapacity(), 15f);
	}
	
	@Test
	public void testANewDeliveryHasNotDeliveredOrders() {
		assertFalse(((Delivery) this.newUser).hasDeliveredOrders());
	}
	
	@Test
	public void testANewDeliveryHasMadeADeliver() {
		this.anOrder = this.juan.makeAnOrder(this.coca, 3);
		this.anOrder.getPrepare();
		((Delivery) this.newUser).deliver(this.anOrder);
		assertTrue(((Delivery) this.newUser).hasDeliveredOrders());
	}
	
}
