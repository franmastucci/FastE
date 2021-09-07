package model.price;

import java.time.LocalDate;

import model.provider.Product;

public abstract class Price {
	
	long id;
	Float value;
	Product product;
	LocalDate startDate;

	protected Price() {}
	
	protected Price(Float aValue, Product aProduct, LocalDate aStartDate) {
		value = aValue;
		product = aProduct;
		startDate = aStartDate;
	}
	
	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}
	
	protected void setValue(Float aValue) {
		this.value = aValue;
	}

	public Product getProduct() {
		return product;
	}

	protected void setProduct(Product product) {
		this.product = product;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	
	protected void setStartDate(LocalDate aStartDate) {
		this.startDate = aStartDate;
	}
	
	public abstract LocalDate getFinishDate();

	protected abstract void setFinishDate(LocalDate aFinishDate);
}
