package model.price;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;
import model.provider.Provider;
	
class CurrentPriceTest {
	private Provider cocaCola;
	private Product coca;
	private Price price;
	
	@BeforeEach
	void setUp() throws Exception {
		 cocaCola = Provider.register(20000000001l,"coca-cola","Avenida Beiró", 20, 20);
		 coca = Product.publishProduct("Coca", cocaCola, 20f, 15.6f);
		 price = CurrentPrice.settlePrice(30.0f, coca);
	}

	@Test
	void testACurrentPriceValueMustBePositive() {
		assertThrows(RuntimeException.class, ()->CurrentPrice.settlePrice(-25f,coca));
	}
	
	@Test
	void testAProductIsNotNull() {
		assertThrows(RuntimeException.class, ()->CurrentPrice.settlePrice(25f,null));
	}
	
	@Test
	void testANewCurrentPriceTakesEffectToday() {
		LocalDate today = LocalDate.now();
		assertEquals(today, price.getStartDate());
	}
	
	@Test
	void testACurrentPriceHasNotAFinishDate(){
		assertThrows(RuntimeException.class,  ()-> price.getFinishDate());
	}
}
