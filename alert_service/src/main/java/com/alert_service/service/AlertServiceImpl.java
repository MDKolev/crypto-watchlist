package com.alert_service.service;

import com.alert_service.entity.Alert;
import com.alert_service.exception.AlertNotFoundException;
import com.alert_service.repository.AlertRepository;
import com.coin_service.entity.Coin;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService{

    private final AlertRepository alertRepository;
    private final WebClient webClient;

    public AlertServiceImpl(AlertRepository alertRepository, WebClient webClient) {
        this.alertRepository = alertRepository;
        this.webClient = webClient;
    }

    private Mono<Coin> fetchCoinById(String coinId) {
        return webClient.get().uri("/{id}", coinId)
                .retrieve()
                .bodyToMono(Coin.class);
    }

    //todo: take care of NullPointerException at line35
    public Alert createAlert(Alert alert) {
        Coin coin = fetchCoinById(alert.getCoinId()).block();

        Alert newAlert = new Alert();
        newAlert.setCoinId(coin.getId());
        newAlert.setUserId(null);
        newAlert.setThresholdPrice(alert.getThresholdPrice());
        newAlert.setCreatedAt(Instant.now());

        return alertRepository.save(newAlert);

    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public void deleteAlert(Long id) {
        if(!alertRepository.existsById(id)) {
            throw new AlertNotFoundException("Count not find alert with ID: " + id);
        }
        alertRepository.deleteById(id);
    }

}
