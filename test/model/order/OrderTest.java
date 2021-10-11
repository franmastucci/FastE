package model.order;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import model.provider.Product;
import model.provider.Provider;
import model.user.Customer;
import model.user.User;

@RunWith(MockitoJUnitRunner.class)
class OrderTest {
	
	@InjectMocks
	private User customer; 
	private Provider cocaCola;
	private Product coca;
	private Order newOrder;

	
	@BeforeEach
	void setUp() throws Exception {
		customer = Customer.register("Pepe", "123@456", "josue", "pep@gmail.com", LocalDate.of(1980, 2, 2));
		cocaCola = Provider.register(20122334459l, "Coca cola", "Av Perón 1234", 20, 30);
		coca = Product.publishProduct("Coca", cocaCola, 20.0f, 35.5f);
		newOrder = Order.newOrder(customer, coca, 10);
	
	}

	@Test
	void testACustomerCanNotBeNull() {
		assertThrows(RuntimeException.class, ()-> Order.newOrder(null, coca, 10));
	}
	
	@Test
	void testAProductCanNotBeNull() {
		assertThrows(RuntimeException.class, ()-> Order.newOrder(customer, null, 10));
	}
	
	@Test
	void testAQuantityCanNotBeNull() {
		assertThrows(RuntimeException.class, ()-> Order.newOrder(customer, coca, -10));
	}
	
	@Test
	void testANewOrderHasAPendingState() {
		assertTrue(newOrder.isPending());
	}
	
	@Test
	void testANewOrderIsNotPrepared() {
		assertFalse(newOrder.isPrepared());
	}
	
	@Test
	void testANewOrderIsNotArrived() {
		assertFalse(newOrder.isArrived());
	}
	
	@Test
	void testANewOrderIsNotCancel() {
		assertFalse(newOrder.isCancel());
	}
	
	@Test
	void testAPreparedOrderIsNotPending () {
		newOrder.getPrepare();
		assertFalse(newOrder.isPending());
	}
	
	@Test
	void testAPreparedOrderIsNotArrived () {
		newOrder.getPrepare();
		assertFalse(newOrder.isArrived());
	}
	
	@Test
	void testAPreparedOrderIsNotCancel () {
		newOrder.getPrepare();
		assertFalse(newOrder.isCancel());
	}
	
	@Test
	void testAPreparedOrderIsPrepared () {
		newOrder.getPrepare();
		assertTrue(newOrder.isPrepared());
	}
	
	@Test
	void testACancelledOrderIsNotPending () {
		newOrder.getCancel();
		assertFalse(newOrder.isPending());
	}
	
	@Test
	void testACancelledOrderIsNotPrepared () {
		newOrder.getCancel();
		assertFalse(newOrder.isPrepared());
	}
	
	@Test
	void testACancelledOrderIsNotArrived () {
		newOrder.getCancel();
		assertFalse(newOrder.isArrived());
	}
	
	@Test
	void testACancelledOrderIsCancel () {
		newOrder.getCancel();
		assertTrue(newOrder.isCancel());
	}
	
	@Test
	void testAnArrivedOrderIsNotPending() {
		newOrder.getPrepare();
		newOrder.getArrive();
		assertFalse(newOrder.isPending());
	}
	
	@Test
	void testAnArrivedOrderIsNotPrepared() {
		newOrder.getPrepare();
		newOrder.getArrive();
		assertFalse(newOrder.isPrepared());
	}
	
	@Test
	void testAnArrivedOrderIsNotCancel() {
		newOrder.getPrepare();
		newOrder.getArrive();
		assertFalse(newOrder.isCancel());
	}
	
	@Test
	void testAnArrivedOrderIsArrive() {
		newOrder.getPrepare();
		newOrder.getArrive();
		assertTrue(newOrder.isArrived());
	}
}
