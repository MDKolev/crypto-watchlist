package com.alert_service.controller;

import com.alert_service.entity.Alert;
import com.alert_service.entity.UpdateThresholdPriceDTO;
import com.alert_service.exception.AlertNotFoundException;
import com.alert_service.exception.InvalidThresholdPriceException;
import com.alert_service.service.AlertServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/alert")
public class AlertController {

    private final AlertServiceImpl alertService;

    public AlertController(AlertServiceImpl alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/new")
    public ResponseEntity<Alert> createAlert(@RequestBody Alert newAlert) {
        Alert alert = alertService.createAlert(newAlert);

        return ResponseEntity.status(HttpStatus.CREATED).body(alert);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Alert>> getAllAlerts() {
        return new ResponseEntity<>(alertService.getAllAlerts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAlertById(@PathVariable Long id) {
        try {
        Alert alert = alertService.getAlertById(id);
        return new ResponseEntity<>(alert, HttpStatus.FOUND);
        } catch (AlertNotFoundException ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", ex.getLocalizedMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateThresholdPrice(@PathVariable Long id, @RequestBody UpdateThresholdPriceDTO dto) {
        try {
            Alert alert = alertService.updateThresholdPrice(id, dto.getThresholdPrice());
            return new ResponseEntity<>(alert, HttpStatus.ACCEPTED);
        } catch (InvalidThresholdPriceException ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getLocalizedMessage());
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteAlertById(@PathVariable Long id){
        try {
            alertService.deleteAlert(id);
            return ResponseEntity.ok("Alert with ID " + id + " was successfully deleted!");
        } catch (AlertNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
        }
    }
}
