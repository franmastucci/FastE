package model.price;

import java.time.LocalDate;

import model.provider.Product;

public abstract class Price {
	
	private long id;
	private Float value;
	private Product product; 
	private LocalDate startDate;

	protected Price() {}
	
	protected Price(Float aValue, Product aProduct, LocalDate aStartDate) {
		this.value = aValue;
		this.product = aProduct;
		this.startDate = aStartDate;
	}
	
	public long getId() {
		return this.id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public Float getValue() {
		return this.value;
	}
	
	protected void setValue(Float aValue) {
		this.value = aValue;
	}

	public Product getProduct() {
		return this.product;
	}

	protected void setProduct(Product product) {
		this.product = product;
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}
	
	protected void setStartDate(LocalDate aStartDate) {
		this.startDate = aStartDate;
	}

	@Override
	public String toString() {
		return "Price value: " + this.getValue();
	}

	public abstract LocalDate getFinishDate();

	protected abstract void setFinishDate(LocalDate aFinishDate);
}
