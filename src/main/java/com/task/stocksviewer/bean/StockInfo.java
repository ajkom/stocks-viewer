package com.task.stocksviewer.bean;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;

public class StockInfo {
    @CsvBindByPosition(position = 0, required = true)
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate date;

    @CsvBindByPosition(position = 1, required = true)
    private double valueNokia;

    @CsvBindByPosition(position = 2, required = true)
    private double valueNordea;

    @CsvBindByPosition(position = 3, required = true)
    private double valueMicrosoft;

    @CsvBindByPosition(position = 4, required = true)
    private double valueTelia;

    public StockInfo() {
    }

    public StockInfo(LocalDate date, double valueNokia, double valueNordea, double valueMicrosoft, double valueTelia) {
        this.date = date;
        this.valueNokia = valueNokia;
        this.valueNordea = valueNordea;
        this.valueMicrosoft = valueMicrosoft;
        this.valueTelia = valueTelia;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValueNokia() {
        return valueNokia;
    }

    public void setValueNokia(double valueNokia) {
        this.valueNokia = valueNokia;
    }

    public double getValueNordea() {
        return valueNordea;
    }

    public void setValueNordea(double valueNordea) {
        this.valueNordea = valueNordea;
    }

    public double getValueMicrosoft() {
        return valueMicrosoft;
    }

    public void setValueMicrosoft(double valueMicrosoft) {
        this.valueMicrosoft = valueMicrosoft;
    }

    public double getValueTelia() {
        return valueTelia;
    }

    public void setValueTelia(double valueTelia) {
        this.valueTelia = valueTelia;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "date='" + date + '\'' +
                ", valueNokia=" + valueNokia +
                ", valueNordea=" + valueNordea +
                ", valueMicrosoft=" + valueMicrosoft +
                ", valueTelia=" + valueTelia +
                '}';
    }
}