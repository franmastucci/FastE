package model;

import java.time.LocalDate;

public abstract class Price {
	
	long id;
	Float value;
	Product product;
	LocalDate startDate;

	public long getId() {
		return id;
	}

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
