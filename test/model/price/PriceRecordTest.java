package model.price;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;

class PriceRecordTest extends PriceTest {

	private CurrentPrice aCurrentPrice;

	@BeforeEach
	public void setUp()  {
		 //Dummy
		this.coca = mock(Product.class);
		this.today = mock(LocalDate.class);
		this.aCurrentPrice = mock(CurrentPrice.class);
		 
		when(this.aCurrentPrice.getValue()).thenReturn(30f);
		when(this.aCurrentPrice.getProduct()).thenReturn(coca);
		when(this.aCurrentPrice.getStartDate()).thenReturn(this.today);
		 
		this.newPrice = PriceRecord.generateRecord(aCurrentPrice);
		this.string = "Price value: 30.0";
	}

	@Test
	void testGenerateARecordPrice() {		
		//exercise
		PriceRecord.generateRecord(this.newPrice);
		
		//verify
		verify(this.aCurrentPrice, atLeast(1)).getValue();
		verify(this.aCurrentPrice, atLeast(1)).getProduct();
		verify(this.aCurrentPrice, atLeast(1)).getStartDate();
	}
	
	@Test
	void testAPriceCanNotBeNotNullToGenerateARecordPrice() {
		assertThrows(RuntimeException.class, ()-> PriceRecord.generateRecord(null));
	}
	
	@Test 
	void testGetFinishDate() {
		LocalDate today = LocalDate.now();
		assertEquals(today, this.newPrice.getFinishDate());
	}

}
