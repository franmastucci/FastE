package model.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;
import model.provider.Provider;

class DeliveryTest extends UserTest{

	@BeforeEach
	public void setup() {
		cocaCola = Provider.register(20122334459l, "coca-cola","Av donato Alvarez 123", 20,30);
		coca = Product.publishProduct("Coca", cocaCola, 20f, 15f);
		juan = Customer.register("Juan ", "prueba_", "CUstomer ", "customer@gmail.com ", LocalDate.of(1988, 8, 1));
		pedro = Delivery.register("Pedro", "prueba2_", "Delivery", "delivery@gmail.com",  LocalDate.of(1988, 8, 1), 20f );
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
	
	@Test
	public void testANewDeliveryHasNotDeliveredOrders() {
		assertFalse(pedro.hasDeliveredOrders());
	}
	
	@Test
	public void testANewDeliveryHasMadeADeliver() {
		anOrder = juan.makeAnOrder(coca, 3);
		anOrder.getPrepare();
		pedro.deliver(anOrder);
		assertTrue(pedro.hasDeliveredOrders());
	}
	
}
