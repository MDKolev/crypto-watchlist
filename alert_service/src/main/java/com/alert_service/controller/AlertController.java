package com.alert_service.controller;

import com.alert_service.entity.Alert;
import com.alert_service.entity.UpdateThresholdPriceDTO;
import com.alert_service.service.AlertServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Alert> createAlert(@RequestBody Alert newAlert) {
        return new ResponseEntity<>(alertService.createAlert(newAlert), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Alert>> getAllAlerts() {
        return new ResponseEntity<>(alertService.getAllAlerts(), HttpStatus.OK);
    }

    @GetMapping("/{coinId}/all")
    public ResponseEntity<List<Alert>> getAllAlertsByCoinId(@PathVariable String coinId) {
        return new ResponseEntity<>(alertService.getAllAlertsByCoinId(coinId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAlertById(@PathVariable Long id) {
        Alert alert = alertService.getAlertById(id);
        return new ResponseEntity<>(alert, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alert> updateThresholdPrice(@PathVariable Long id, @RequestBody UpdateThresholdPriceDTO dto) {
            Alert alert = alertService.updateThresholdPrice(id, dto.getThresholdPrice());
            return new ResponseEntity<>(alert, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlertById(@PathVariable Long id){
            alertService.deleteAlert(id);
            return ResponseEntity.ok("Alert with ID " + id + " was successfully deleted!");
    }
}
