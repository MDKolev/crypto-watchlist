package com.coin_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CoinService {

    private final String API_URL = "https://api.coingecko.com/api/v3";
    private final RestTemplate restTemplate;

    @Value("coingecko.api.key")
    private String apiKey;

    public CoinService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}

