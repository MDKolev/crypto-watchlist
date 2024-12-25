package com.coin_service.controller;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;
<<<<<<< HEAD
import com.coin_service.service.CoinService;
import org.springframework.http.HttpStatus;
=======
import com.coin_service.service.CoinServiceImpl;
>>>>>>> alert_service
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/coins")
public class CoinController {

    private final CoinServiceImpl coinServiceImpl;

    public CoinController(CoinServiceImpl coinServiceImpl) {
        this.coinServiceImpl = coinServiceImpl;
    }

    @GetMapping("/all")
<<<<<<< HEAD
    public Flux<Coin> getAllCoins() {
        return ResponseEntity.status(HttpStatus.OK).body(coinService.getAllCoins()).getBody();
=======
    public List<Coin> getAllCoins() {
        return coinServiceImpl.getAllCoins();
>>>>>>> alert_service
    }

    @PutMapping("/save")
    public void saveCoins() {
        coinServiceImpl.saveCoins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coin> getCoinByID(@PathVariable("id") String id) {
<<<<<<< HEAD
        return new ResponseEntity<>(coinService.getCoinById(id), HttpStatus.FOUND);
=======
        return coinServiceImpl.getCoinById(id);
>>>>>>> alert_service
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<CoinDetailsForWatchlistDTO> getCoinDetailsForWatchlistDTO(@PathVariable("id") String id) {
<<<<<<< HEAD
        return new ResponseEntity<>(coinService.getCoinDetailsForWatchlist(id), HttpStatus.OK);
=======
        return coinServiceImpl.getCoinDetailsForWatchlist(id);
>>>>>>> alert_service
    }

}

