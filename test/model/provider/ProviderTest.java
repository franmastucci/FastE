package model.provider;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProviderTest {
	
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
		assertThrows(RuntimeException.class, ()->Provider.register(20000000001l, "Cepita", "  ", 20, 30));
	}

}
