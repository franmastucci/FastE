package model;

import java.time.LocalDate;

public class PriceRecord {
	private final Float value;
	private final LocalDate startDate;
	private final LocalDate finishDate;
	
	private PriceRecord(Float aValue, LocalDate aStartDate, LocalDate aFinishDate) {
		value = aValue;
		startDate = aStartDate;
		finishDate =  aFinishDate;
	}
	
	public static PriceRecord generateRecord(Price aPrice) {
		
		LocalDate aFinisgDate = LocalDate.now();
		return new PriceRecord(aPrice.getValue(), aPrice.getStartDate(), aFinisgDate);
	}
 	
}
