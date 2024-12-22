package com.coin_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;
import com.coin_service.mapper.ManualMapper;
import com.coin_service.repository.CoinRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class CoinService {

    private final String API_URL = "https://api.coingecko.com/api/v3";

    private final RestTemplate restTemplate;

    private final CoinRepository coinRepository;

    private final ManualMapper manualMapper;


    public CoinService(RestTemplate restTemplate, CoinRepository coinRepository, ManualMapper manualMapper) {
        this.restTemplate = restTemplate;
        this.coinRepository = coinRepository;
        this.manualMapper = manualMapper;
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

    public void saveCoins() {
        List<Coin> allCoins = getAllCoins();

        allCoins.forEach(coinRepository::save);
        System.out.println("saved");
    }

    public ResponseEntity<Coin> getCoinById(String id) {
        Optional<Coin> coin = coinRepository.findById(id);

        if (coin.isPresent()) {
            Coin foundCoin = coin.get();
            return ResponseEntity.ok(foundCoin);
        } else {
            return null;
        }
    }

    public ResponseEntity<CoinDetailsForWatchlistDTO> getCoinDetailsForWatchlist(String id) {
        Coin coin = getCoinById(id).getBody();

        CoinDetailsForWatchlistDTO coinDetailsForWatchlistDTO = manualMapper.mapCoinToCoinDetailsForWatchlistDTO(coin);

        return ResponseEntity.ok(coinDetailsForWatchlistDTO);
    }

}

