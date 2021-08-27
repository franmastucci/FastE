package model;

import java.time.LocalDate;

public class PriceRecord extends Price{
	
	private final LocalDate finishDate;
	
	private PriceRecord(Float aValue, LocalDate aStartDate, LocalDate aFinishDate) {
		value = aValue;
		startDate = aStartDate;
		finishDate =  aFinishDate;
	}
	
	public static PriceRecord generateRecord(Price aPrice) {
		
		LocalDate aFinishDate = LocalDate.now();
		return new PriceRecord(aPrice.getValue(), aPrice.getStartDate(), aFinishDate);
	}

	@Override
	public LocalDate getFinishDate() {
		return finishDate;
	}
 	
}
