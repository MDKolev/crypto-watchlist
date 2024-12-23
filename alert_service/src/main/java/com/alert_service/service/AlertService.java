package com.alert_service.service;

import com.alert_service.entity.Alert;

import java.util.List;

public interface AlertService {

    Alert createAlert(Alert alert);

    List<Alert> getAllAlerts();

    Alert getAlertById(Long id);

    void deleteAlert(Long id);


}
