package model.price;

import java.time.LocalDate;

import model.provider.Product;

public class CurrentPrice extends Price{

	private String IS_CURRENT_PRICE = "El precio es el actual por lo que aun no tiene fecha de finalizacion";
	
	
	protected CurrentPrice() {}
	
	//Requerido por hibernate
	protected CurrentPrice(Float aValue, Product aProduct, LocalDate aStartDate) {
		super(aValue, aProduct, aStartDate);
	}
		
	//Metodo de acceso publico para crear instancias de CurrentPrice
	public static Price settlePrice(Float aPriceValue, Product aProduct) {
		LocalDate aStartDate = LocalDate.now();
		return new CurrentPrice(aPriceValue, aProduct, aStartDate);
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
