package com.coin_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.mapper.ManualMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

}

