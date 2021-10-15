package model.price;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.provider.Product;
	
public abstract class PriceTest {

	protected String string;
	protected Product coca;
	protected LocalDate today;
	protected Price newPrice;
	
	@Test
	public void testGetValue() {
		assertEquals(30f, this.newPrice.getValue());	
	}
	
	@Test
	public void testGetProduct() {
		assertEquals(this.coca, this.newPrice.getProduct());	
	}
	
	@Test
	public void testGetStartDate() {
		assertEquals(this.today, this.newPrice.getStartDate());	
	}
	
	@Test
	public void testToString() {
		assertEquals(this.string, this.newPrice.toString());	
	}

}
