package com.alert_service.controller;

import com.alert_service.entity.Alert;
import com.alert_service.service.AlertService;
import com.alert_service.service.AlertServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alert")
public class AlertController {

    private final AlertServiceImpl alertService;

    public AlertController(AlertServiceImpl alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/new")
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        Alert newAlert = alertService.createAlert(alert.getUserId(),
                alert.getCoinName(), alert.getThresholdPrice());
        return new ResponseEntity<>(newAlert, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Alert>> getAllAlerts() {
        return new ResponseEntity<>(alertService.getAllAlerts(), HttpStatus.OK);
    }
}
