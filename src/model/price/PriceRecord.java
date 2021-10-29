package model.price;

import java.time.LocalDate;

import javax.persistence.*;

import model.provider.Product;
@Entity
public class PriceRecord extends Price{
	
	private static final String INVALID_PRICE = "El precio no puede ser nulo";
	@Column
	private LocalDate finishDate;
	
	
	@SuppressWarnings("unused")
	private PriceRecord() {}
	
	//Reuerido por hibernate
	protected PriceRecord(Float aValue, Product aProduct, LocalDate aStartDate, LocalDate aFinishDate) {
		super(aValue, aProduct, aStartDate);
		this.finishDate =  aFinishDate;
	}

	//Metodo de acceso publico para crear instancias de PriceRecord
	public static PriceRecord generateRecord(Price aPrice) {
		asserIsValidPrice(aPrice);
		
		LocalDate aFinishDate = LocalDate.now();
		return new PriceRecord(aPrice.getValue(), aPrice.getProduct(), aPrice.getStartDate(), aFinishDate);
	}

	private static void asserIsValidPrice(Price aPrice) {
		if (!isValidPrice(aPrice)) throw new RuntimeException(INVALID_PRICE);
	}

	private static boolean isValidPrice(Price aPrice) {
		return aPrice != null;
	}

	@Override
	public LocalDate getFinishDate() {
		return this.finishDate;
	}
	
	@Override
	protected void setFinishDate(LocalDate aFinishDate) {
		this.finishDate = aFinishDate;
	}

}
