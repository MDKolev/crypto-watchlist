package com.coin_service.controller;

import com.coin_service.entity.Coin;
import com.coin_service.service.CoinService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cryptos")
public class CoinController {

    private final CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/all")
    public List<Coin> getAllCoins() {
        return coinService.getAllCoins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coin> getCoinByID(@PathVariable("id") String id) {
        return coinService.getCoinById(id);
    }


}

