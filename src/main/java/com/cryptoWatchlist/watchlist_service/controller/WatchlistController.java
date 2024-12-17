package com.cryptoWatchlist.watchlist_service.controller;

import com.cryptoWatchlist.watchlist_service.entity.Watchlist;
import com.cryptoWatchlist.watchlist_service.service.WatchlistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/watchlists")
public class WatchlistController {

    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @PostMapping
    public ResponseEntity<Watchlist> createWatchlist(@RequestBody Watchlist watchlist) {
        Watchlist savedWatchlist = watchlistService.createWatchlist(watchlist);
        return new ResponseEntity<>(savedWatchlist, HttpStatus.CREATED);
    }
}
