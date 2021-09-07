package model.price;

import java.time.LocalDate;

import model.provider.Product;

public class PriceRecord extends Price{
	
	private LocalDate finishDate;
	
	
	protected PriceRecord() {}
	
	//Reuerido por hibernate
	protected PriceRecord(Float aValue, Product aProduct, LocalDate aStartDate, LocalDate aFinishDate) {
		super(aValue, aProduct, aStartDate);
		finishDate =  aFinishDate;
	}

	//Metodo de acceso publico para crear instancias de PriceRecord
	public static PriceRecord generateRecord(Price aPrice) {
		LocalDate aFinishDate = LocalDate.now();
		return new PriceRecord(aPrice.getValue(), aPrice.getProduct(), aPrice.getStartDate(), aFinishDate);
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
