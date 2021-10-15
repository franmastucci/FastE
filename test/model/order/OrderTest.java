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
		
		this.customer = Customer.register("Pepe", "123@456", "josue", "pep@gmail.com", LocalDate.of(1980, 2, 2));
		this.cocaCola = Provider.register(20122334459l, "Coca cola", "Av Perón 1234", 20, 30);
		this.coca = Product.publishProduct("Coca", this.cocaCola, 20.0f, 35.5f);
		this.newOrder = Order.newOrder(this.customer, coca, 10);
	
	}

	@Test
	void testACustomerCanNotBeNull() {
		assertThrows(RuntimeException.class, ()-> Order.newOrder(null, this.coca, 10));
	}
	
	@Test
	void testAProductCanNotBeNull() {
		assertThrows(RuntimeException.class, ()-> Order.newOrder(this.customer, null, 10));
	}
	
	@Test
	void testAQuantityCanNotBeNull() {
		assertThrows(RuntimeException.class, ()-> Order.newOrder(this.customer, this.coca, -10));
	}
	
	@Test
	void testANewOrderHasAPendingState() {
		assertTrue(this.newOrder.isPending());
	}
	
	@Test
	void testANewOrderIsNotPrepared() {
		assertFalse(this.newOrder.isPrepared());
	}
	
	@Test
	void testANewOrderIsNotArrived() {
		assertFalse(this.newOrder.isArrived());
	}
	
	@Test
	void testANewOrderIsNotCancel() {
		assertFalse(this.newOrder.isCancel());
	}
	
	@Test
	void testAPreparedOrderIsNotPending () {
		this.newOrder.getPrepare();
		assertFalse(this.newOrder.isPending());
	}
	
	@Test
	void testAPreparedOrderIsNotArrived () {
		this.newOrder.getPrepare();
		assertFalse(this.newOrder.isArrived());
	}
	
	@Test
	void testAPreparedOrderIsNotCancel () {
		this.newOrder.getPrepare();
		assertFalse(this.newOrder.isCancel());
	}
	
	@Test
	void testAPreparedOrderIsPrepared () {
		this.newOrder.getPrepare();
		assertTrue(this.newOrder.isPrepared());
	}
	
	@Test
	void testACancelledOrderIsNotPending () {
		this.newOrder.getCancel();
		assertFalse(this.newOrder.isPending());
	}
	
	@Test
	void testACancelledOrderIsNotPrepared () {
		this.newOrder.getCancel();
		assertFalse(this.newOrder.isPrepared());
	}
	
	@Test
	void testACancelledOrderIsNotArrived () {
		this.newOrder.getCancel();
		assertFalse(this.newOrder.isArrived());
	}
	
	@Test
	void testACancelledOrderIsCancel () {
		this.newOrder.getCancel();
		assertTrue(this.newOrder.isCancel());
	}
	
	@Test
	void testAnArrivedOrderIsNotPending() {
		this.newOrder.getPrepare();
		this.newOrder.getArrive();
		assertFalse(this.newOrder.isPending());
	}
	
	@Test
	void testAnArrivedOrderIsNotPrepared() {
		this.newOrder.getPrepare();
		this.newOrder.getArrive();
		assertFalse(this.newOrder.isPrepared());
	}
	
	@Test
	void testAnArrivedOrderIsNotCancel() {
		this.newOrder.getPrepare();
		this.newOrder.getArrive();
		assertFalse(this.newOrder.isCancel());
	}
	
	@Test
	void testAnArrivedOrderIsArrive() {
		this.newOrder.getPrepare();
		this.newOrder.getArrive();
		assertTrue(this.newOrder.isArrived());
	}
}
