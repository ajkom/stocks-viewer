package com.task.stocksviewer.bean;

import java.time.LocalDate;

public class DateValue {
	private LocalDate date;
	private Float value;

	public DateValue() {
	}

	public DateValue(LocalDate date, Float value) {
		this.date = date;
		this.value = value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
}
