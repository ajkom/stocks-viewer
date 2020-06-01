package com.task.stocksviewer.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Map data from the CSV file
 */
@Entity
public class StocksInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CsvBindByPosition(position = 0, required = true)
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate date;

    @CsvBindByPosition(position = 1, required = true)
    @JsonProperty("Nokia")
    private double valueNokia;

    @CsvBindByPosition(position = 2, required = true)
    @JsonProperty("Nordea")
    private double valueNordea;

    @CsvBindByPosition(position = 3, required = true)
    @JsonProperty("Microsoft")
    private double valueMicrosoft;

    @CsvBindByPosition(position = 4, required = true)
    @JsonProperty("Telia")
    private double valueTelia;

    public StocksInfo() {
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
        return "FullStockInfo{" +
                "date=" + date +
                ", valueNokia=" + valueNokia +
                ", valueNordea=" + valueNordea +
                ", valueMicrosoft=" + valueMicrosoft +
                ", valueTelia=" + valueTelia +
                '}';
    }
}