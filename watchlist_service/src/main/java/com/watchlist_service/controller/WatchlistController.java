package com.watchlist_service.controller;

import com.coin_service.entity.Coin;
import com.watchlist_service.entity.NewWatchlistDTO;
import com.watchlist_service.entity.Watchlist;
import com.watchlist_service.service.WatchlistService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/watchlists")
public class WatchlistController {

    private final WatchlistService watchlistService;

    public WatchlistController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    @PostMapping("/new")
    public ResponseEntity<Watchlist> createWatchlist(@Valid @RequestBody NewWatchlistDTO newWatchlistDTO) {
        Watchlist savedWatchlist = watchlistService.createWatchlist(newWatchlistDTO);
        return new ResponseEntity<>(savedWatchlist, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Watchlist>> getAllWatchlists() {
        List<Watchlist> allWatchlists = watchlistService.getAllWatchlists();
        return new ResponseEntity<>(allWatchlists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Watchlist> getWatchlistById(@PathVariable Long id) {
        Watchlist watchlist = watchlistService.getWatchlistById(id);
        return new ResponseEntity<>(watchlist, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteWatchlistById(@PathVariable Long id) {
            watchlistService.deleteWatchlistById(id);
            return ResponseEntity.ok("Watchlist with ID " +id + " was successfully deleted!");
    }

    @PutMapping("/{id}/rename")
    public ResponseEntity<Watchlist> renameWatchlist(@PathVariable Long id, @RequestBody String newName) {
        Watchlist renamedWatchlist = watchlistService.renameWatchlist(id, newName);
        return new ResponseEntity<>(renamedWatchlist, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/{coinId}/add")
    public ResponseEntity<Mono<Watchlist>> addCoinToWatchlist(@PathVariable Long id, @PathVariable String coinId) {
        Mono<Watchlist> updatedWatchlist = watchlistService.addCoinToWatchlist(id, coinId);
        return new ResponseEntity<>(updatedWatchlist, HttpStatus.ACCEPTED);
    }
}
