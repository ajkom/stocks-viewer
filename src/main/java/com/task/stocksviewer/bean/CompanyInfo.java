package com.task.stocksviewer.bean;

import java.time.LocalDate;
import java.util.List;

public class CompanyInfo {
	private String name;
	private List<DateValue> dateValueList;

	public CompanyInfo() {
	}

	public CompanyInfo(String name, List<DateValue> dateValueList) {
		this.name = name;
		this.dateValueList = dateValueList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DateValue> getDateValueList() {
		return dateValueList;
	}

	public void setDateValueList(List<DateValue> dateValueList) {
		this.dateValueList = dateValueList;
	}

	public void addDateValue(LocalDate date, double value){
		this.dateValueList.add(new DateValue(date, value));
	}
}
