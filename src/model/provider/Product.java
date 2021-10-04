package model.provider;
import java.util.*;
import model.price.CurrentPrice;
import model.price.Price;
import model.price.PriceRecord;


public class Product {
	private static final String INVALID_NAME = "El nombre no puede estar en blanco";
	private static final String INVALID_PPRICE_VALUE = "EL valor del precio debe ser positivo";
	private static final String INVALID_WEIGHT = "El peso del producto debe ser mayor a 0 y menor a 20";
	private static final String INVALID_PROVIDER = "Debe ingresar un proveedor no nulo ";
	private String name;
	private Provider provider;
	private Float weight;
	private Price price;
	private List<PriceRecord> priceStory;
	
	private Product() {}
	
	//Constructor creado para cumplir con requerimientos de Hibernate
	private Product(String aName, Provider aProvider, Float aWeight, Price aPrice, List<PriceRecord> aPriceStory) {
		this.name = aName;
		this.provider = aProvider;
		this.weight = aWeight;
		this.price = aPrice;
		this.priceStory = aPriceStory;
	}

	private Product(String aName, Provider aProvider, Float aWeight, Float aPriceValue) {
		this.name = aName;
		this.provider = aProvider;
		this.weight = aWeight;
		this.price = CurrentPrice.settlePrice(aPriceValue, this);
		this.priceStory = new ArrayList<PriceRecord>();
	}

	//Metodo de acceso publico para crear instancias de Product
	public static Product publishProduct(String aName, Provider aProvider, Float aWeight, Float aPriceValue)  {
		
		assertIsValidName(aName); 
		assertIsValidValue(aPriceValue);
		assertIsValidWeight(aWeight);
		assertIsValidProvider(aProvider);	
		return new Product(aName, aProvider, aWeight, aPriceValue);
	}

	private static void assertIsValidProvider(Provider aProvider) {
		if(!isValidProvider(aProvider) ) throw new RuntimeException(INVALID_PROVIDER);
	}

	private static boolean isValidProvider(Provider aProvider) {
		return aProvider != null;
	}

	private static void assertIsValidWeight(Float aWeight) {
		if(!isValidWeight(aWeight)) throw new RuntimeException(INVALID_WEIGHT);
	}

	private static boolean isValidWeight(Float aWeight) {
		return aWeight > 0 && aWeight <= 20;
	}

	private static void assertIsValidValue(Float aPriceValue) {
		if(!isValidValue(aPriceValue)) throw new RuntimeException(INVALID_PPRICE_VALUE);
	}

	private static boolean isValidValue(Float aPriceValue) {
		return aPriceValue > 0;
	}

	private static void assertIsValidName(String aName) {
		if(!isValidName(aName)) throw new RuntimeException(INVALID_NAME);
	}

	private static boolean isValidName(String aName) {
		return !aName.isBlank();
	}

	public String getName() {
		return name;
	}
	
	@SuppressWarnings("unused")
	private void setName(String aName) {
		this.name = aName;
	}	

	public Provider getProvider() {
		return provider;
	}

	@SuppressWarnings("unused")
	private void setProvider(Provider aProvider) {
		this.provider = aProvider;
	}		
	
	public Float getWeight() {
		return weight;
	}

	@SuppressWarnings("unused")
	private void setWeight(Float aWeight) {
		this.weight = aWeight;
	}	

	public Price getPrice() {
		return price;
	}
	
	private void setPrice(Price aPrice) {
		this.price = aPrice;
	}	

	public List<PriceRecord> getPriceStory() {
		return priceStory;
	}
	
	public void setPriceStory(List<PriceRecord> aPriceRecord) {
		this.priceStory = aPriceRecord;
	}
	
	public void updatePrice(Float aNewPriceValue) {
		PriceRecord priceToRecord = PriceRecord.generateRecord(this.getPrice());
		Price newPrice = CurrentPrice.settlePrice(aNewPriceValue, this);
		this.getPriceStory().add(priceToRecord);
		this.setPrice(newPrice);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", provider=" + provider + ", weight=" + weight + ", price=" + price.getValue() + "]";
	}
	
}
