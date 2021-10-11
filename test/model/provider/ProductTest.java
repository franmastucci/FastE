package model.provider;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;


class ProductTest {
	//Dependiente (la que se quiere probar) SUT
	
	//Dependencia (la clase de la que depende su comportamiento) Provider.class
	private Provider cocaCola = mock(Provider.class);

	@Test
	void testNameCanNotBeBlank() {
		System.out.println(cocaCola);
		assertThrows(RuntimeException.class, ()->Product.publishProduct(" ", cocaCola, 20f, 50f));
	}
	
	@Test
	void testPriceValueMustBePositive() {
		assertThrows(RuntimeException.class, ()->Product.publishProduct("Cepita", cocaCola, 10f,-20f));
	}
	
	@Test
	void testWeightMustBeLessThan( ) {
		assertThrows(RuntimeException.class, ()->Product.publishProduct("Cepita", cocaCola, 30f, 20f));
	}
	
	@Test
	void testProviderMustBeValid() {
		assertThrows(RuntimeException.class, ()->Product.publishProduct("Cepita", null, 20f, 20f));
	}

}
