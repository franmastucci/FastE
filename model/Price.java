package model;

import java.time.LocalDate;
import java.util.*;

public class Price {
	
	private Float value;
	private LocalDate startDate;
	private final List<PriceRecord> priceStory;
	
	private Price(Float aValue, LocalDate aStartDate) {
		value = aValue;
		startDate = aStartDate;
		priceStory  = new ArrayList<PriceRecord>();
	}
	
	public static Price initialPrice(Float aPriceValue) {
		LocalDate aStartDate = LocalDate.now();
		return  new Price(aPriceValue, aStartDate) ;
	}	

	public Float getValue() {
		return value;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public List<PriceRecord> getPriceStory() {
		return priceStory;
	}
	
	public void updateValue(Float aNewValue) {
		this.priceStory.add(PriceRecord.generateRecord(this));
		this.value = aNewValue;
		this.startDate = LocalDate.now();		
	}

}
