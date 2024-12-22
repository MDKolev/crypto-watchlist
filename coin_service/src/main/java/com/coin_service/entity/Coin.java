package com.coin_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Instant;

@Entity
public class Coin {

    @Id
    private String id;`

    @Column
    private String symbol;

    @Column
    private String name;

    @Column
    private String image;

    @Column
    private Number current_price;

    @Column
    private Number market_cap;

    @Column
    private Number market_cap_rank;

    @Column
    private Number fully_diluted_valuation;

    @Column
    private Number total_volume;

    @Column
    private Number high_24h;

    @Column
    private Number low_24h;

    @Column
    private Number price_change_24h;

    @Column
    private Number price_change_percentage_24h;

    @Column
    private Number market_cap_change_24h;

    @Column
    private Number market_cap_change_percentage_24h;

    @Column
    private Number circulating_supply;

    @Column
    private Number total_supply;

    @Column
    private Number max_supply;

    @Column
    private Number ath;

    @Column
    private Number ath_change_percentage;

    @Column
    private Instant ath_date;

    @Column
    private Number atl;

    @Column
    private Number atl_change_percentage;

    @Column
    private Instant atl_date;

    @Column
    private Instant last_updated;

    public Coin() {
    }

    public Coin(String id, String symbol, String name, String image, Number current_price, Number market_cap, Number market_cap_rank, Number fully_diluted_valuation, Number total_volume, Number high_24h, Number low_24h, Number price_change_24h, Number price_change_percentage_24h, Number market_cap_change_24h, Number market_cap_change_percentage_24h, Number circulating_supply, Number total_supply, Number max_supply, Number ath, Number ath_change_percentage, Instant ath_date, Number atl, Number atl_change_percentage, Instant atl_date, Instant last_updated) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.image = image;
        this.current_price = current_price;
        this.market_cap = market_cap;
        this.market_cap_rank = market_cap_rank;
        this.fully_diluted_valuation = fully_diluted_valuation;
        this.total_volume = total_volume;
        this.high_24h = high_24h;
        this.low_24h = low_24h;
        this.price_change_24h = price_change_24h;
        this.price_change_percentage_24h = price_change_percentage_24h;
        this.market_cap_change_24h = market_cap_change_24h;
        this.market_cap_change_percentage_24h = market_cap_change_percentage_24h;
        this.circulating_supply = circulating_supply;
        this.total_supply = total_supply;
        this.max_supply = max_supply;
        this.ath = ath;
        this.ath_change_percentage = ath_change_percentage;
        this.ath_date = ath_date;
        this.atl = atl;
        this.atl_change_percentage = atl_change_percentage;
        this.atl_date = atl_date;
        this.last_updated = last_updated;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Number getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Number current_price) {
        this.current_price = current_price;
    }

    public Number getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(Number market_cap) {
        this.market_cap = market_cap;
    }

    public Number getMarket_cap_rank() {
        return market_cap_rank;
    }

    public void setMarket_cap_rank(Number market_cap_rank) {
        this.market_cap_rank = market_cap_rank;
    }

    public Number getFully_diluted_valuation() {
        return fully_diluted_valuation;
    }

    public void setFully_diluted_valuation(Number fully_diluted_valuation) {
        this.fully_diluted_valuation = fully_diluted_valuation;
    }

    public Number getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(Number total_volume) {
        this.total_volume = total_volume;
    }

    public Number getHigh_24h() {
        return high_24h;
    }

    public void setHigh_24h(Number high_24h) {
        this.high_24h = high_24h;
    }

    public Number getLow_24h() {
        return low_24h;
    }

    public void setLow_24h(Number low_24h) {
        this.low_24h = low_24h;
    }

    public Number getPrice_change_24h() {
        return price_change_24h;
    }

    public void setPrice_change_24h(Number price_change_24h) {
        this.price_change_24h = price_change_24h;
    }

    public Number getPrice_change_percentage_24h() {
        return price_change_percentage_24h;
    }

    public void setPrice_change_percentage_24h(Number price_change_percentage_24h) {
        this.price_change_percentage_24h = price_change_percentage_24h;
    }

    public Number getMarket_cap_change_24h() {
        return market_cap_change_24h;
    }

    public void setMarket_cap_change_24h(Number market_cap_change_24h) {
        this.market_cap_change_24h = market_cap_change_24h;
    }

    public Number getMarket_cap_change_percentage_24h() {
        return market_cap_change_percentage_24h;
    }

    public void setMarket_cap_change_percentage_24h(Number market_cap_change_percentage_24h) {
        this.market_cap_change_percentage_24h = market_cap_change_percentage_24h;
    }

    public Number getCirculating_supply() {
        return circulating_supply;
    }

    public void setCirculating_supply(Number circulating_supply) {
        this.circulating_supply = circulating_supply;
    }

    public Number getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(Number total_supply) {
        this.total_supply = total_supply;
    }

    public Number getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(Number max_supply) {
        this.max_supply = max_supply;
    }

    public Number getAth() {
        return ath;
    }

    public void setAth(Number ath) {
        this.ath = ath;
    }

    public Number getAth_change_percentage() {
        return ath_change_percentage;
    }

    public void setAth_change_percentage(Number ath_change_percentage) {
        this.ath_change_percentage = ath_change_percentage;
    }

    public Instant getAth_date() {
        return ath_date;
    }

    public void setAth_date(Instant ath_date) {
        this.ath_date = ath_date;
    }

    public Number getAtl() {
        return atl;
    }

    public void setAtl(Number atl) {
        this.atl = atl;
    }

    public Number getAtl_change_percentage() {
        return atl_change_percentage;
    }

    public void setAtl_change_percentage(Number atl_change_percentage) {
        this.atl_change_percentage = atl_change_percentage;
    }

    public Instant getAtl_date() {
        return atl_date;
    }

    public void setAtl_date(Instant atl_date) {
        this.atl_date = atl_date;
    }

    public Instant getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Instant last_updated) {
        this.last_updated = last_updated;
    }
}

