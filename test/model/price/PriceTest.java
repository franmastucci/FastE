package model.price;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;
import model.provider.Provider;
import model.user.Delivery;
	
public class PriceTest {
	protected Provider cocaCola;
	protected Product coca;
	protected Price newPrice;
	
	
	@BeforeEach
	public void setUp()  {
		
		this.newPrice = mock(CurrentPrice.class);
		//when(this.newPrice.getId()).thenReturn(1234567l);
		when(this.newPrice.getValue()).thenReturn(30f);
		when(this.newPrice.getProduct()).thenReturn(coca);
		when(this.newPrice.getStartDate()).thenReturn(LocalDate.now());
	}

//	@Test
//	public void testGetId() {
//		assertEquals(1234567l, this.newPrice.getId());	
//	}
	
	@Test
	public void testGetValue() {
		assertEquals(30f, this.newPrice.getValue());	
	}
	
	@Test
	public void testGetProduct() {
		assertEquals(coca, this.newPrice.getProduct());	
	}
	
	@Test
	public void testGetStartDate() {
		assertEquals(LocalDate.now(), this.newPrice.getStartDate());	
	}

}
