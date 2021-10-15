package model.price;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;

public class CurrentPriceTest extends PriceTest {

	@BeforeEach
	public void setUp()  {
		//Dummy (sirve para relleno de parametros de la instancia del SUT)
		 this.coca = mock(Product.class);
		 
		 this.today = LocalDate.now();
		 this.newPrice = CurrentPrice.settlePrice(30f, coca); 
		 this.string = "Price value: 30.0";
	}

	@Test
	public void testSettlePrice() {
		assertDoesNotThrow(()->CurrentPrice.settlePrice(30f, coca));
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
		assertEquals(this.today, this.newPrice.getStartDate());
	}
	
	@Test
	public void testACurrentPriceHasNotAFinishDate(){
		assertThrows(RuntimeException.class,  ()-> this.newPrice.getFinishDate());
	}
}
