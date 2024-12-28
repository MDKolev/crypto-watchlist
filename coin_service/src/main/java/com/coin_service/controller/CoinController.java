package com.coin_service.controller;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;
import com.coin_service.service.CoinService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


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
    public ResponseEntity<String> saveCoins() {
        coinService.saveCoins();
        return ResponseEntity.status(HttpStatus.OK).body("Coins saved successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coin> getCoinByID(@PathVariable("id") String id) {
        return new ResponseEntity<>(coinService.getCoinById(id), HttpStatus.FOUND);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<CoinDetailsForWatchlistDTO> getCoinDetailsForWatchlistDTO(@PathVariable("id") String id) {
        return new ResponseEntity<>(coinService.getCoinDetailsForWatchlist(id), HttpStatus.OK);
    }

}

