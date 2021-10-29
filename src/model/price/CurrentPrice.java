package model.price;

import java.time.LocalDate;

import javax.persistence.*;

import model.provider.Product;
@Entity
public class CurrentPrice extends Price{

	private static final String INVALID_PRICE_VALUE = "El precio del producto debe ser positivo";
	private static final String INVALID_PRODUCT = "El producto no puede ser nulo";
	private String IS_CURRENT_PRICE = "El precio es el actual por lo que aun no tiene fecha de finalizacion";
	
	
	@SuppressWarnings("unused")
	private CurrentPrice() {}
	
	//Requerido por hibernate
	protected CurrentPrice(Float aValue, Product aProduct, LocalDate aStartDate) {
		super(aValue, aProduct, aStartDate);
	}
		
	//Metodo de acceso publico para crear instancias de CurrentPrice
	public static CurrentPrice settlePrice(Float aPriceValue, Product aProduct) {
		
		assertIsAValidPriceValue(aPriceValue);
		assertIsAValidProduct(aProduct);

		LocalDate aStartDate = LocalDate.now();
		return new CurrentPrice(aPriceValue, aProduct, aStartDate);
	}

	private static void assertIsAValidProduct(Product aProduct) {
		if(!isValidProduct(aProduct)) throw new RuntimeException(INVALID_PRODUCT);
	}

	private static boolean isValidProduct(Product aProduct) {
		return aProduct != null;
	}

	private static void assertIsAValidPriceValue(Float aPriceValue) {
		if (!isValidPriceValue(aPriceValue)) throw new RuntimeException(INVALID_PRICE_VALUE);
	}

	private static boolean isValidPriceValue(Float aPriceValue) {
		return aPriceValue > 0;
	}
	
	@Override
	public LocalDate getFinishDate() {
		throw new RuntimeException(IS_CURRENT_PRICE);
	}
	
	@Override
	protected void setFinishDate(LocalDate aFinishDate) {
		throw new RuntimeException(IS_CURRENT_PRICE);
	}

}
