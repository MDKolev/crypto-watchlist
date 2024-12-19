package com.coin_service.controller;

import com.coin_service.entity.Coin;
import com.coin_service.service.CoinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cryptos")
public class CryptoDataController {

    private final CoinService coinService;

    public CryptoDataController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/all")
    public List<Object> getAllCoins() {
        return coinService.getAllCoins();
    }

}

