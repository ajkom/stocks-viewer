package com.task.stocksviewer.bean;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;

public class StockInfo {
    @CsvBindByPosition(position = 0, required = true)
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate date;

    @CsvBindByPosition(position = 1, required = true)
    private String valueNokia;

    @CsvBindByPosition(position = 2, required = true)
    private float valueNordea;

    @CsvBindByPosition(position = 3, required = true)
    private float valueMicrosoft;

    @CsvBindByPosition(position = 4, required = true)
    private float valueTelia;

    public StockInfo() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getValueNokia() {
        return valueNokia;
    }

    public void setValueNokia(String valueNokia) {
        this.valueNokia = valueNokia;
    }

    public float getValueNordea() {
        return valueNordea;
    }

    public void setValueNordea(float valueNordea) {
        this.valueNordea = valueNordea;
    }

    public float getValueMicrosoft() {
        return valueMicrosoft;
    }

    public void setValueMicrosoft(float valueMicrosoft) {
        this.valueMicrosoft = valueMicrosoft;
    }

    public float getValueTelia() {
        return valueTelia;
    }

    public void setValueTelia(float valueTelia) {
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