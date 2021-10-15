package model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;


import model.order.Order;
import model.provider.Product;
import model.provider.Provider;

public abstract class UserTest {
	
	protected User newUser;
	protected Customer juan;
	protected Delivery pedro;
	protected Provider cocaCola;
	protected Product coca;
	protected Order anOrder;
	
//	@BeforeEach
//	public void setUp(){
//		this.newUser = mock(Delivery.class);
//		when(this.newUser.getName()).thenReturn("newUser");
//		when(this.newUser.getUserName()).thenReturn("newUserUsername");
//		when(this.newUser.getPass()).thenReturn("12345");
//		when(this.newUser.getBirthday()).thenReturn(LocalDate.now());
//		when(this.newUser.getEmail()).thenReturn("pepe@gmail.com");
//	}
	
	@Test
	public void testGetUserName() {
		assertEquals("newUserUsername", this.newUser.getUserName());	
	}
	
	@Test
	public void testGetName() {
		assertEquals("newUser", this.newUser.getName());
	}
	
	@Test
	public void testGetPass() {
		assertEquals("123@45", this.newUser.getPass());
	}
	@Test
	public void testGetBirthday() {
		LocalDate birthday = LocalDate.of(1988, 8, 1);
		assertEquals(birthday, this.newUser.getBirthday());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("pepe@gmail.com", this.newUser.getEmail());
	}
		
}
