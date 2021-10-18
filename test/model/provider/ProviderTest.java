package model.provider;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProviderTest {
	
	private Provider cocaCola;
	
	@BeforeEach
	public void setup() {
		cocaCola = Provider.register(20000000001l, "Coca Cola","Avenida Beiró", 20, 30);
//		cocaCola= mock(Provider.class);
//		when(cocaCola.getCuil()).thenReturn(20000000001l);
//		when(cocaCola.getName()).thenReturn("Coca Cola");
//		when(cocaCola.getAdress()).thenReturn("Avenida Beiró");
//		when(cocaCola.getxCoordinate()).thenReturn(20);
//		when(cocaCola.getyCoordinate()).thenReturn(30);
	}
	
	@Test
	void testCuilMustBeMoreThan() {
		assertThrows(RuntimeException.class, ()->Provider.register(20l, "Cepita","Avenida Beiró", 20, 20));
	}
	
	@Test
	void testCuilMustBeLessThan() {
		assertThrows(RuntimeException.class, ()->Provider.register(21000000000l, "Cepita","Avenida Beiró", 20, 20));
	}
	
	@Test
	void testNameCanNotBeBlank() {
		assertThrows(RuntimeException.class, ()->Provider.register(20000000001l, "   ","Avenida Beiró", 20, 20));
	}
	
	@Test
	void testAddressCanNotBeBlank() {
		assertThrows(RuntimeException.class, ()->Provider.register(20000000001l, "Coca Cola"," ", 20, 30));
	}
	
	@Test
	void testGetCuil() {
		assertEquals(20000000001l, cocaCola.getCuil());
	}
	
	@Test
	void testGetName() {
		assertEquals("Coca Cola", cocaCola.getName());
	}
	
	@Test
	void testGetAddress() {
		assertEquals("Avenida Beiró", this.cocaCola.getAdress());
	}
	
	@Test
	void testGetXCoordinate() {
		assertEquals( 20, cocaCola.getxCoordinate());
	}
	
	@Test
	void testGetYCoordinate() {
		assertEquals( 30, cocaCola.getyCoordinate());
	}
	
	@Test
	void testRegister() {
		assertDoesNotThrow(()->Provider.register(20000000001l,"Coca Cola","Avenida Beiró", 20, 30));
	}
	
	@Test
	void testToString() {
		assertEquals("Provider [cuil=" + cocaCola.getCuil() + ", name=" + cocaCola.getName() + ", adress=" + cocaCola.getAdress() + 
				", xCoordinate=" + cocaCola.getxCoordinate() + ", yCoordinate=" + cocaCola.getyCoordinate() + "]", cocaCola.toString());
	}

}


