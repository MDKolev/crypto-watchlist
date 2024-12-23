package com.alert_service.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "coin_name")
    private String coinName;

    @Column(name = "threshold_price")
    private Double thresholdPrice;

    @Column
    private boolean triggered;

    private Instant createdAt;

    public Alert() {
    }

    public Alert(long id, long userId, String coinName, Double thresholdPrice, boolean triggered, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.coinName = coinName;
        this.thresholdPrice = thresholdPrice;
        this.triggered = triggered;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public Double getThresholdPrice() {
        return thresholdPrice;
    }

    public void setThresholdPrice(Double thresholdPrice) {
        this.thresholdPrice = thresholdPrice;
    }

    public boolean isTriggered() {
        return triggered;
    }

    public void setTriggered(boolean triggered) {
        this.triggered = triggered;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
