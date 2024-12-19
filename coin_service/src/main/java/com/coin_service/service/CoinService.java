package com.coin_service.service;

import com.coin_service.entity.Coin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Service
public class CoinService {

    private final String API_URL = "https://api.coingecko.com/api/v3";
    private final RestTemplate restTemplate;

//    @Value("coingecko.api.key")
//    private String apiKey;

    public CoinService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Object> getAllCoins() {
        String url = String.format("%s/coins/markets?vs_currency=usd", API_URL);

        Object[] coins = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(coins);


    }
}

