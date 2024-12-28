package com.alert_service.service;

import com.alert_service.entity.Alert;
import com.alert_service.exception.AlertNotFoundException;
import com.alert_service.exception.CoinNotFoundException;
import com.alert_service.exception.InvalidThresholdPriceException;
import com.alert_service.repository.AlertRepository;
import com.coin_service.entity.Coin;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService{

    private final String COINS_URL = "http://localhost:8081/api/coins";

    private final AlertRepository alertRepository;
    private final RestTemplate restTemplate;

    public AlertServiceImpl(AlertRepository alertRepository, RestTemplate restTemplate) {
        this.alertRepository = alertRepository;
        this.restTemplate = restTemplate;
    }

    public Coin fetchCoinById(String coinId) {
        String url = String.format("%s/%s", COINS_URL, coinId);

        try {
            return restTemplate.getForEntity(url, Coin.class).getBody();
        } catch (HttpClientErrorException exception) {
            throw new CoinNotFoundException(coinId);
        }
    }

    public Alert createAlert(Alert alert) {
        Coin coin = fetchCoinById(alert.getCoinId());

        if (coin != null) {
            Alert newAlert = new Alert();
            newAlert.setCoinId(coin.getId());
            newAlert.setUserId(null);
            newAlert.setThresholdPrice(alert.getThresholdPrice());
            newAlert.setCreatedAt(Instant.now().toString());
            return alertRepository.save(newAlert);
        } else {
            throw new CoinNotFoundException(coin.getId());
        }
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public Alert getAlertById(Long id) {
        Optional<Alert> alert = alertRepository.findById(id);

        if (alert.isPresent()) {
            return alert.get();
        } else {
            throw new AlertNotFoundException(id);
        }
    }

    public List<Alert> getAllAlertsByCoinId(String coinId) {
        List<Alert> byCoinId = alertRepository.findByCoinId(coinId);

        if (byCoinId.isEmpty()) {
            throw new CoinNotFoundException(coinId);
        } else {
            return byCoinId;
        }
    }

    public Alert updateThresholdPrice(Long id, Double thresholdPrice) {
        if(thresholdPrice > 0) {
            Alert alertById = getAlertById(id);
            alertById.setThresholdPrice(thresholdPrice);
            alertRepository.save(alertById);
            return alertById;
        } else {
            throw new InvalidThresholdPriceException(thresholdPrice);
        }
    }

    public void deleteAlert(Long id) {
        if(!alertRepository.existsById(id)) {
            throw new AlertNotFoundException(id);
        }
        alertRepository.deleteById(id);
    }

    @Scheduled(fixedDelay = 60000)
    private void checkAlertsThreshold() {
        List<Alert> alerts = alertRepository.findAll();

        for (Alert alert : alerts) {
            Coin coin = fetchCoinById(alert.getCoinId());

            if (coin != null) {
                double currentPrice = coin.getCurrent_price().doubleValue();
                if (currentPrice >= alert.getThresholdPrice()) {
                    alert.setTriggered(true);
                    alertRepository.save(alert);
                    System.out.println("Alert triggered for coin: " + alert.getCoinId() + " at price: " + currentPrice);
                }
            }
        }
    }
}
