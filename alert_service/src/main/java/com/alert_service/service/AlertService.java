package com.alert_service.service;

import com.alert_service.entity.Alert;
import com.alert_service.entity.UpdateThresholdPriceDTO;

import java.util.List;

public interface AlertService {

    Alert createAlert(Alert alert);

    List<Alert> getAllAlerts();

    Alert getAlertById(Long id);

    List<Alert> getAllAlertsByCoinId(String coinId);

    Alert updateThresholdPrice(Long id, Double thresholdPrice);

    void deleteAlert(Long id);


}
