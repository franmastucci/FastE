package model.price;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;
import model.provider.Provider;
	
class PriceTest {
	private Provider cocaCola;
	private Product coca;
	private Price price;
	
	
	@BeforeEach
	void setUp() throws Exception {
		 this.cocaCola = Provider.register(20000000001l,"coca-cola","Avenida Beir�", 20, 20);
		 this.coca = Product.publishProduct("Coca", cocaCola, 20f, 15.6f);
		 this.price = CurrentPrice.settlePrice(30.0f, coca);
	}

	@Test
	void testACurrentPriceValueMustBePositive() {
		assertThrows(RuntimeException.class, ()->CurrentPrice.settlePrice(-25f, this.coca));
	}
	
	@Test
	void testAProductIsNotNull() {
		assertThrows(RuntimeException.class, ()->CurrentPrice.settlePrice(25f,null));
	}
	
	@Test
	void testANewCurrentPriceTakesEffectToday() {
		LocalDate today = LocalDate.now();
		assertEquals(today, this.price.getStartDate());
	}
	
	@Test
	void testACurrentPriceHasNotAFinishDate(){
		assertThrows(RuntimeException.class,  ()-> this.price.getFinishDate());
	}
	
	@Test
	void testAPriceCanNotBeNotNullToGenerateARecordPrice() {
		assertThrows(RuntimeException.class, ()-> PriceRecord.generateRecord(null));
	}
}
