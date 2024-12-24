package com.coin_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;
import com.coin_service.exception.CoinNotFoundException;
import com.coin_service.exception.NoCoinsToSaveException;
import com.coin_service.mapper.ManualMapper;
import com.coin_service.repository.CoinRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.*;


@Service
public class CoinServiceImpl implements CoinService {

    private final String API_URL = "/coins/markets?vs_currency=usd";

    private final WebClient webClient;

    private final CoinRepository coinRepository;

    private final ManualMapper manualMapper;


    public CoinServiceImpl(WebClient webClient, CoinRepository coinRepository, ManualMapper manualMapper) {
        this.webClient = webClient;
        this.coinRepository = coinRepository;
        this.manualMapper = manualMapper;
    }

//    @Value("coingecko.api.key")
//    private String apiKey;


    public Flux<Coin> getAllCoins() {
        return webClient.get().uri(API_URL).retrieve().bodyToFlux(Coin.class);
    }

    public void saveCoins() {
        Flux<Coin> allCoins = getAllCoins();
        List<Coin> coinsList = allCoins.collectList().block();

        if (coinsList != null && !coinsList.isEmpty()) {
            coinsList.forEach(coinRepository::save);
        } else {
            throw new NoCoinsToSaveException();
        }
    }

    public Coin getCoinById(String id) {
        Optional<Coin> coin = coinRepository.findById(id);

        if (coin.isPresent()) {
            return coin.get();
        } else {
            throw new CoinNotFoundException(id);
        }
    }

//    public ResponseEntity<CoinDetailsForWatchlistDTO> getCoinDetailsForWatchlist(String id) {
//        Coin coin = getCoinById(id).getBody();
//
//        CoinDetailsForWatchlistDTO coinDetailsForWatchlistDTO = manualMapper.mapCoinToCoinDetailsForWatchlistDTO(coin);
//
//        return ResponseEntity.ok(coinDetailsForWatchlistDTO);
//    }

    @Scheduled(fixedDelay = 60000)
    public void updateCoins() {
        saveCoins();
    }

}

