package com.coin_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoinService {

    List<Coin> getAllCoins();
    void saveCoins();
    ResponseEntity<Coin> getCoinById(String id);
    ResponseEntity<CoinDetailsForWatchlistDTO> getCoinDetailsForWatchlist(String id);
    void updateCoins();

}
