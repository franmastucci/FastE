package model;
import java.util.*;

public class Product {
	private final String name;
	private final Provider provider;
	private final Float weight;
	private Price price;
	private final List<PriceRecord> priceStory;
	
	private Product(String aName, Provider aProvider, Float aWeight, Price aPrice) {
		name = aName;
		provider = aProvider;
		weight = aWeight;
		price = aPrice;
		priceStory = new ArrayList<PriceRecord>();
	}
	
	//Sigue la l�gica de la implementacion del m�todo "register" en los usuarios "Customer"  y "Delivery"
	public static Product publishProduct(String aName, Provider aProvider, Float aWeight, Float aPriceValue)  {
		Price aPrice = CurrentPrice.initialPrice(aPriceValue);
		return new Product(aName, aProvider, aWeight, aPrice);
	}

	public String getName() {
		return name;
	}

	public Provider getProvider() {
		return provider;
	}

	public Float getWeight() {
		return weight;
	}

	public Float getPrice() {
		return price.getValue();
	}

	public List<PriceRecord> getPriceStory() {
		return priceStory;
	}
	
	public void updatePrice(Float aNewPriceValue) {
		PriceRecord priceToRecord = PriceRecord.generateRecord(this.price);
		priceStory.add(priceToRecord);
		this.price = CurrentPrice.initialPrice(aNewPriceValue);
	}
}
