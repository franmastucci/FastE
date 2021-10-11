package model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import model.order.Order;
import model.provider.Product;
import model.provider.Provider;



public class UserTest {
	
	protected User newUser;
	protected Customer juan;
	protected Delivery pedro;
	protected Provider cocaCola;
	protected Product coca;
	protected Order anOrder;
	
	@BeforeEach
	public void setUp(){
		this.newUser = mock(Delivery.class);
		when(this.newUser.getName()).thenReturn("newUser");
		when(this.newUser.getUserName()).thenReturn("newUserUsername");
	}
	
	@Test
	public void testGetUserName() {
		assertEquals("newUserUsername", this.newUser.getUserName());	
	}
	
	@Test
	public void testGetName() {
		assertEquals("newUser", this.newUser.getName());
	}
		
}
