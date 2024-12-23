package com.alert_service.service;

import com.alert_service.entity.Alert;
import com.alert_service.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
public class AlertServiceImpl implements AlertService{

    private final AlertRepository alertRepository;

    public AlertServiceImpl(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public Alert createAlert(Long userId, String coinName, Double thresholdPRice) {
        Alert newAlert = new Alert();
        newAlert.setUserId(userId);
        newAlert.setCoinName(coinName);
        newAlert.setThresholdPrice(thresholdPRice);
        newAlert.setTriggered(false);
        newAlert.setCreatedAt(Instant.now());

        return alertRepository.save(newAlert);
    }

}
