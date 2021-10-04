package model.provider;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	private Provider cocaCola ;

	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testNameCanNotBeBlank() {
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
