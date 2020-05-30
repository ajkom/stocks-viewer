package com.task.stocksviewer.bean;

import java.time.LocalDate;

public class DateValue {
	private LocalDate date;
	private double value;

	public DateValue() {
	}

	public DateValue(LocalDate date, double value) {
		this.date = date;
		this.value = value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
