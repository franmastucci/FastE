package model;

import java.time.LocalDate;

public class CurrentPrice extends Price{

	private final String IS_CURRENT_PRICE = "El precio es el actual por lo que aun no tiene fecha de finalizacion";
	
//	private CurrentPrice(Float aValue, LocalDate aStartDate) {
//		value = aValue;
//		startDate = aStartDate;
//	}
	
	private CurrentPrice() {}
	
	public static Price settlePrice(Float aPriceValue, Product aProduct) {
		CurrentPrice newCurrentPrice = new CurrentPrice();
		LocalDate aStartDate = LocalDate.now();
		newCurrentPrice.setValue(aPriceValue);
		newCurrentPrice.setProduct(aProduct);
		newCurrentPrice.setStartDate(aStartDate);
		return  newCurrentPrice;
	}
	
	@Override
	public LocalDate getFinishDate() {
		throw new RuntimeException(IS_CURRENT_PRICE);
	}
	
	@Override
	public void setFinishDate(LocalDate aFinishDate) {
		throw new RuntimeException(IS_CURRENT_PRICE);
	}

}
