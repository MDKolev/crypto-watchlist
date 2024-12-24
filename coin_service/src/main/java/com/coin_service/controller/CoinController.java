package com.coin_service.controller;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;
import com.coin_service.service.CoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
public class CoinController {

    private final CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/all")
    public Flux<Coin> getAllCoins() {
        return ResponseEntity.status(HttpStatus.OK).body(coinService.getAllCoins()).getBody();
    }

    @PutMapping("/save")
    public void saveCoins() {
        coinService.saveCoins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coin> getCoinByID(@PathVariable("id") String id) {
        return new ResponseEntity<>(coinService.getCoinById(id), HttpStatus.FOUND);
    }

//    @GetMapping("/details/{id}")
//    public ResponseEntity<CoinDetailsForWatchlistDTO> getCoinDetailsForWatchlistDTO(@PathVariable("id") String id) {
//        return coinService.getCoinDetailsForWatchlist(id);
//    }

}

