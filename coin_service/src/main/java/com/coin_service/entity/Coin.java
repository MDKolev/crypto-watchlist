package com.coin_service.entity;

import jakarta.persistence.*;

@Entity
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String api_id;

    @Column
    private String name;

    @Column
    private String symbol;

    @Column(name = "current_price")
    private double currentPrice;

    @Column(name = "price_change_24h")
    private double priceChange24h;

    @Column(name = "percentage_change_24h")
    private double percentageChange24h;

    public Coin() {
    }

    public Coin(String api_id, String name, String symbol, double currentPrice, double priceChange24h, double percentageChange24h) {
        this.api_id = api_id;
        this.name = name;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
        this.priceChange24h = priceChange24h;
        this.percentageChange24h = percentageChange24h;
    }

    public String getApi_id() {
        return api_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getPriceChange24h() {
        return priceChange24h;
    }

    public void setPriceChange24h(double priceChange24h) {
        this.priceChange24h = priceChange24h;
    }

    public double getPercentageChange24h() {
        return percentageChange24h;
    }

    public void setPercentageChange24h(double percentageChange24h) {
        this.percentageChange24h = percentageChange24h;
    }
}
