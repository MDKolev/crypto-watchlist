package com.cryptoWatchlist.watchlist_service.controller;

import com.cryptoWatchlist.watchlist_service.entity.Watchlist;
import com.cryptoWatchlist.watchlist_service.exception.WatchlistNotFoundException;
import com.cryptoWatchlist.watchlist_service.service.WatchlistService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Watchlist>> getAllWatchlists() {
        List<Watchlist> allWatchlists = watchlistService.getAllWatchlists();
        return new ResponseEntity<>(allWatchlists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Watchlist> getWatchlistById(@PathVariable long id) {
        Watchlist watchlist = watchlistService.getWatchlistById(id);
        return new ResponseEntity<>(watchlist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWatchlistById(@PathVariable long id) {
        try {
            watchlistService.deleteWatchlistById(id);
            return ResponseEntity.ok("Watchlist with ID " +id + " was successfully deleted!");
        } catch (WatchlistNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
        }
    }

}
