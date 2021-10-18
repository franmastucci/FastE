package model.provider;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Faste;
import model.price.CurrentPrice;
import model.price.Price;
import model.price.PriceRecord;


class ProductTest {
	//Dependiente (la que se quiere probar) SUT
	private Product coca;
	//Dependencia (la clase de la que depende su comportamiento) Provider.class
	private Provider cocaCola = mock(Provider.class);
	private Price newPrice = mock(CurrentPrice.class);

	@BeforeEach
	public void setup() {
		 coca = Product.publishProduct("Coca-Cola", cocaCola, 20.0f, 200.0f);
	}

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
	
	@Test
	public void testPublishProduct() {
		assertDoesNotThrow(()->Product.publishProduct("Coca Cola", cocaCola, 20.0f, 100.0f));
	}
	
	@Test
	public void testGetName() {
		assertEquals("Coca-Cola", this.coca.getName());	
	}
	
	@Test
	public void testGetProvider() {
		assertEquals(cocaCola, this.coca.getProvider());	
	}
	
	@Test
	public void testGetWeight() {
		assertEquals(20.0f, this.coca.getWeight());	
	}
	
	@Test
	public void testGetPrice() {
		when(newPrice.getValue()).thenReturn(200.0f);
		Product product = Product.publishProduct("Coca", cocaCola, 20.0f, newPrice.getValue());
		assertEquals(newPrice.getValue(), product.getPrice().getValue());	
	}
	
	@Test
	public void testUpdatePrice() {
		coca.updatePrice(300.0f);
		assertEquals(300.0f, coca.getPrice().getValue());	
	}
	
	@Test
	public void testToString() {
		assertEquals("Product [name=" + coca.getName() + ", provider=" + coca.getProvider() 
		+ ", weight=" + coca.getWeight() + ", price=" + coca.getPrice().getValue() + "]", coca.toString());	
	}
	
	@Test						// se requiere cambiar la visibilidad del constructor a probar 
	public void testHibernateConstructor() {
		Price newPrice = mock(CurrentPrice.class);
		List<PriceRecord> priceStory = mock(List.class);
		assertDoesNotThrow(()-> new Product("Coca-Cola", cocaCola, 20.0f, newPrice, priceStory));
	}
	

}
