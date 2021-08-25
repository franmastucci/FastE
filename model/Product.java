package model;

public class Product {
	private  final String name;
	private  final Provider provider;
	private  final Float weight;
	private  final Price price;
	
	private Product(String aName, Provider aProvider, Float aWeight, Price aPrice) {
		name = aName;
		provider = aProvider;
		weight = aWeight;
		price = aPrice;
	}
	
	//Sigue la l�gica de la implementacion del m�todo "register" en los usuarios "Customer"  y "Delivery"
	public Product publishProduct(String aName, Provider aProvider, Float aWeight, Float aPriceValue)  {
		Price aPrice = Price.initialPrice(aPriceValue);
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
}
