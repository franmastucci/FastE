package model.price;

import java.time.LocalDate;

import model.provider.Product;

public class CurrentPrice extends Price{

	private String IS_CURRENT_PRICE = "El precio es el actual por lo que aun no tiene fecha de finalizacion";
	
	
	private CurrentPrice() {}

	//Constructor creado para cumplir con requerimientos de Hibernate
	private CurrentPrice(Float aValue, LocalDate aStartDate, Product aProduct) {
		value = aValue;
		startDate = aStartDate;
		product = aProduct;
	}
	
	private CurrentPrice(Float aValue, Product aProduct) {
		value = aValue;
		startDate = LocalDate.now();
		product = aProduct;
	}
	
	//Metodo de acceso publico para crear instancias de CurrentPrice
	public static Price settlePrice(Float aPriceValue, Product aProduct) {
		return new CurrentPrice(aPriceValue, aProduct);
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
