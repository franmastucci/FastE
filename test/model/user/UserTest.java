package model.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import model.provider.Product;
//import org.junit.jupiter.api.BeforeEach;
//import static org.junit.Assert.assertFalse;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import model.order.Order;
import model.provider.Product;
import model.provider.Provider;



public class UserTest {
	
	private Customer newUser;
	private Customer juan;
	private Delivery pedro;
	private Provider cocaCola;
	private Product coca;
	private Order anOrder;
	
	@BeforeEach
	public void setup() {
		newUser = Customer.register("usuario de prueba", "pass de prueba_","nombre de prueba", "prueba@gmail.com", LocalDate.of(1988, 8, 1));
		juan = Customer.register("Juan ", "prueba_", "CUstomer ", "customer@gmail.com ", LocalDate.of(1988, 8, 1));
		cocaCola = Provider.register(20122334459l, "coca-cola","Av donato Alvarez 123", 20,30);
		coca = Product.publishProduct("Coca", cocaCola, 20f, 15f);
		anOrder = juan.makeAnOrder(coca, 3);
		pedro = Delivery.register("Pedro", "prueba2_", "Delivery", "delivery@gmail.com",  LocalDate.of(1988, 8, 1), 20f );
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
		assertFalse(newUser.hasMadeAnOrder());
	}
	
	@Test
	public void testCustomerHasMadeAnOrder() {
		assertTrue(juan.hasMadeAnOrder());
	}
	
	@Test
	public void testDliveryHasCapacityMoreThan() {
		assertThrows(RuntimeException.class, ()->Delivery.register("Pedro", "prueba2_", "Delivery", "delivery@gmail.com",  LocalDate.of(1988, 8, 1), -1f )); 
	}
	
	@Test
	public void testDliveryHasCapacityLessThan() {
		assertThrows(RuntimeException.class, ()->Delivery.register("Pedro", "prueba2_", "Delivery", "delivery@gmail.com",  LocalDate.of(1988, 8, 1), 25f )); 
	}
		
	@Test
	public void testANewDeliveryHasNotDeliveredOrders() {
		assertFalse(pedro.hasDeliveredOrders());
	}
	
	@Test
	public void testANewDeliveryHasMadeADeliver() {
		anOrder.getPrepare();
		pedro.deliver(anOrder);
		assertTrue(pedro.hasDeliveredOrders());
	}
	
}
