package com.alert_service.service;

import com.alert_service.entity.Alert;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AlertService {

    Alert createAlert(Long userId, String coinName, Double thresholdPRice);

    List<Alert> getAllAlerts();


}
