package model;

import java.time.LocalDate;

public abstract class Price {
	
	Float value;
	LocalDate startDate;

	public Float getValue() {
		return value;
	}
	
	protected void setValue(Float aValue) {
		this.value = aValue;
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
