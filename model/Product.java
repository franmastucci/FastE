package model;
import java.util.*;

public class Product {
	private String name;
	private Provider provider;
	private Float weight;
	private Price price;
	private List<PriceRecord> priceStory;
	
	private Product(String aName, Provider aProvider, Float aWeight, Price aPrice) {
		name = aName;
		provider = aProvider;
		weight = aWeight;
		price = aPrice;
		priceStory = new ArrayList<PriceRecord>();
	}
	
	private Product() {}
	
	//Sigue la l�gica de la implementacion del m�todo "register" en los usuarios "Customer"  y "Delivery"
	public static Product publishProduct(String aName, Provider aProvider, Float aWeight, Float aPriceValue)  {
		Product newProduct = new Product();
		List<PriceRecord> aPriceStory = new ArrayList<PriceRecord>();
		Price aPrice = CurrentPrice.settlePrice(aPriceValue);
		newProduct.setName(aName);
		newProduct.setProvider(aProvider);
		newProduct.setWeight(aWeight);
		newProduct.setPrice(aPrice);
		newProduct.setPriceStory(aPriceStory);
		return newProduct;
	}
	
	public static Product publishProduct(String aName, Provider aProvider, Float aWeight, Price aPrice)  {
		Product newProduct = new Product();
		List<PriceRecord> aPriceStory = new ArrayList<PriceRecord>();
		newProduct.setName(aName);
		newProduct.setProvider(aProvider);
		newProduct.setWeight(aWeight);
		newProduct.setPrice(aPrice);
		newProduct.setPriceStory(aPriceStory);
		return newProduct;
	}

	public String getName() {
		return name;
	}
	
	private void setName(String aName) {
		this.name = aName;
	}	

	public Provider getProvider() {
		return provider;
	}

	private void setProvider(Provider aProvider) {
		this.provider = aProvider;
	}		
	
	public Float getWeight() {
		return weight;
	}

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
		PriceRecord priceToRecord = PriceRecord.generateRecord(this.price);
		priceStory.add(priceToRecord);
		this.price = CurrentPrice.settlePrice(aNewPriceValue);
	}
}
