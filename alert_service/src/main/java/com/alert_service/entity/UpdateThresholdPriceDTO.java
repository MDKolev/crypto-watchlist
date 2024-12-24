package com.alert_service.entity;

public class UpdateThresholdPriceDTO {

    private Double thresholdPrice;

    public UpdateThresholdPriceDTO() {
    }

    public UpdateThresholdPriceDTO(Double thresholdPrice) {
        this.thresholdPrice = thresholdPrice;
    }

    public Double getThresholdPrice() {
        return thresholdPrice;
    }

    public void setThresholdPrice(Double thresholdPrice) {
        this.thresholdPrice = thresholdPrice;
    }
}
