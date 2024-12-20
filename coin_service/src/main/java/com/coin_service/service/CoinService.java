package com.coin_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.mapper.ManualMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class CoinService {

    private final ManualMapper manualMapper;

    private final String API_URL = "https://api.coingecko.com/api/v3";
    private final RestTemplate restTemplate;

//    @Value("coingecko.api.key")
//    private String apiKey;

    public CoinService(ManualMapper manualMapper, RestTemplate restTemplate) {
        this.manualMapper = manualMapper;
        this.restTemplate = restTemplate;
    }

    public List<Coin> getAllCoins() {
        String url = String.format("%s/coins/markets?vs_currency=usd", API_URL);

        Object[] coinObjects = restTemplate.getForObject(url, Object[].class);
        if (coinObjects.length == 0) {
            return List.of();
        }

        return Arrays.stream(coinObjects)
                .filter(obj -> obj instanceof Map)
                .map(manualMapper::mapObjectToCoin)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Coin> getCoinById(String id) {
        Coin coin = getAllCoins().stream()
                .filter(c -> c.getApi_id().equals(id))
                .findFirst()
                .orElse(null);

        if (coin != null) {
            return ResponseEntity.ok(coin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

