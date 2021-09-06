package model.provider;
import java.util.*;

import model.price.CurrentPrice;
import model.price.Price;
import model.price.PriceRecord;

public class Product {
	private String name;
	private Provider provider;
	private Float weight;
	private Price price;
	private List<PriceRecord> priceStory;
	
	private Product() {}
	
	//Constructor creado para cumplir con requerimientos de Hibernate
	private Product(String aName, Provider aProvider, Float aWeight, Price aPrice, List<PriceRecord> aPriceStory) {
		name = aName;
		provider = aProvider;
		weight = aWeight;
		price = aPrice;
		priceStory = aPriceStory;
	}

	private Product(String aName, Provider aProvider, Float aWeight, Float aPriceValue) {
		name = aName;
		provider = aProvider;
		weight = aWeight;
		price = CurrentPrice.settlePrice(aPriceValue, this);
		priceStory = new ArrayList<PriceRecord>();
	}

	//Metodo de acceso publico para crear instancias de Product
	public static Product publishProduct(String aName, Provider aProvider, Float aWeight, Float aPriceValue)  {
		return new Product(aName, aProvider, aWeight, aPriceValue);
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
}
