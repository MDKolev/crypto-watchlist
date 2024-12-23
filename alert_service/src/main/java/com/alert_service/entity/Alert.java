package com.alert_service.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "coin_name")
    private String coinName;

    @Column(name = "threshold_price")
    private Double thresholdPrice;

    @Column
    private boolean triggered = false;

    private Instant createdAt;

    public Alert() {
    }

    public Alert(Long id, Long userId, String coinName, Double thresholdPrice, boolean triggered, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.coinName = coinName;
        this.thresholdPrice = thresholdPrice;
        this.triggered = triggered;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
