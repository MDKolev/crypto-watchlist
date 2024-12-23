package com.coin_service.controller;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;
import com.coin_service.service.CoinServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
public class CoinController {

    private final CoinServiceImpl coinServiceImpl;

    public CoinController(CoinServiceImpl coinServiceImpl) {
        this.coinServiceImpl = coinServiceImpl;
    }

    @GetMapping("/all")
    public List<Coin> getAllCoins() {
        return coinServiceImpl.getAllCoins();
    }

    @PutMapping("/save")
    public void saveCoins() {
        coinServiceImpl.saveCoins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coin> getCoinByID(@PathVariable("id") String id) {
        return coinServiceImpl.getCoinById(id);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<CoinDetailsForWatchlistDTO> getCoinDetailsForWatchlistDTO(@PathVariable("id") String id) {
        return coinServiceImpl.getCoinDetailsForWatchlist(id);
    }

}

