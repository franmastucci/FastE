package model;

import java.time.LocalDate;

public abstract class Price {
	
	Float value;
	LocalDate startDate;

	public Float getValue() {
		return value;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	
	public abstract LocalDate getFinishDate();

}
