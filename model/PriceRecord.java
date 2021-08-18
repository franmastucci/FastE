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
		
		LocalDate aFinishDate = LocalDate.now();
		return new PriceRecord(aPrice.getValue(), aPrice.getStartDate(), aFinishDate);
	}

	public Float getValue() {
		return value;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}
 	
}
