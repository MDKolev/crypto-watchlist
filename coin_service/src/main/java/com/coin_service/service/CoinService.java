package com.coin_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;
import reactor.core.publisher.Flux;


public interface CoinService {

    Flux<Coin> getAllCoins();
    void saveCoins();
    Coin getCoinById(String id);
    CoinDetailsForWatchlistDTO getCoinDetailsForWatchlist(String id);
    void updateCoins();

}
