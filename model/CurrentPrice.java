package model;

import java.time.LocalDate;

public class CurrentPrice extends Price{

	private final String IS_CURRENT_PRICE = "El precio es el actual por lo que aun no tiene fecha de finalizacion";
	
	private CurrentPrice(Float aValue, LocalDate aStartDate) {
		value = aValue;
		startDate = aStartDate;
	}
	
	public static Price initialPrice(Float aPriceValue) {
		LocalDate aStartDate = LocalDate.now();
		return  new CurrentPrice(aPriceValue, aStartDate);
	}

	@Override
	public LocalDate getFinishDate() {
		throw new RuntimeException(IS_CURRENT_PRICE);
	}	

}
