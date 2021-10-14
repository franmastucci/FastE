package model.price;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;
import model.provider.Provider;

public class CurrentPriceTest extends PriceTest {

	@BeforeEach
	public void setUp()  {
		 this.cocaCola = Provider.register(20000000001l,"coca-cola","Avenida Beiró", 20, 20);
		 this.coca = Product.publishProduct("Coca", cocaCola, 20f, 15.6f);
		 this.newPrice = CurrentPrice.settlePrice(30.0f, coca); 
	}

	@Test
	public void testACurrentPriceValueMustBePositive() {
		assertThrows(RuntimeException.class, ()->CurrentPrice.settlePrice(-25f, this.coca));
	}
	
	@Test
	public void testAProductIsNotNull() {
		assertThrows(RuntimeException.class, ()->CurrentPrice.settlePrice(25f,null));
	}
	
	@Test
	public void testANewCurrentPriceTakesEffectToday() {
		LocalDate today = LocalDate.now();
		assertEquals(today, this.newPrice.getStartDate());
	}
	
	@Test
	public void testACurrentPriceHasNotAFinishDate(){
		assertThrows(RuntimeException.class,  ()-> this.newPrice.getFinishDate());
	}
}
