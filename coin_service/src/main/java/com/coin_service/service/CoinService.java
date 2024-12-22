package com.coin_service.service;

import com.coin_service.entity.Coin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class CoinService {

    private final String API_URL = "https://api.coingecko.com/api/v3";

    private final RestTemplate restTemplate;


    public CoinService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    @Value("coingecko.api.key")
//    private String apiKey;


    public List<Coin> getAllCoins() {
        String url = String.format("%s/coins/markets?vs_currency=usd", API_URL);

        ResponseEntity<Coin[]> response = restTemplate.getForEntity(url, Coin[].class);

        Coin[] coins = response.getBody();
        if (coins.length == 0) {
            return List.of();
        }

        return Arrays.asList(coins);
    }

}

