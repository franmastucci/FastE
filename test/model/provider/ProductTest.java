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
		assertThrows(RuntimeException.class, ()->Product.publishProduct(" ", this.cocaCola, 20f, 50f));
	}
	
	@Test
	void testPriceValueMustBePositive() {
		assertThrows(RuntimeException.class, ()->Product.publishProduct("Cepita", this.cocaCola, 10f,-20f));
	}
	
	@Test
	void testWeightMustBeLessThan( ) {
		assertThrows(RuntimeException.class, ()->Product.publishProduct("Cepita", this.cocaCola, 30f, 20f));
	}
	
	@Test
	void testProviderMustBeValid() {
		assertThrows(RuntimeException.class, ()->Product.publishProduct("Cepita", null, 20f, 20f));
	}

}
