package com.coin_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CoinService {

    Flux<Coin> getAllCoins();
    void saveCoins();
    Coin getCoinById(String id);
//    ResponseEntity<CoinDetailsForWatchlistDTO> getCoinDetailsForWatchlist(String id);
    void updateCoins();

}
