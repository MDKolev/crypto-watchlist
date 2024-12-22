package com.coin_service.controller;

import com.coin_service.entity.Coin;
import com.coin_service.service.CoinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
public class CoinController {

    private final CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/all")
    public List<Coin> getAllCoins() {
        return coinService.getAllCoins();
    }

    @PutMapping("/save")
    public void saveCoins() {
        coinService.saveCoins();
    }


}

