package model;

import java.time.LocalDate;

public class PriceRecord extends Price{
	
	private LocalDate finishDate;
	
//	private PriceRecord(Float aValue, LocalDate aStartDate, LocalDate aFinishDate) {
//		value = aValue;
//		startDate = aStartDate;
//		finishDate =  aFinishDate;
//	}
	
	private PriceRecord() {}
	
	public static PriceRecord generateRecord(Price aPrice, Product aProduct) {
		PriceRecord newPriceRecord = new PriceRecord();
		LocalDate aFinishDate = LocalDate.now();
		newPriceRecord.setValue(aPrice.getValue());
		newPriceRecord.setProduct(aProduct);
		newPriceRecord.setStartDate(aPrice.getStartDate());
		newPriceRecord.setFinishDate(aFinishDate);
		return newPriceRecord;
	}

	@Override
	public LocalDate getFinishDate() {
		return finishDate;
	}
	
	@Override
	protected void setFinishDate(LocalDate aFinishDate) {
		this.finishDate = aFinishDate;
	}
 	
}
