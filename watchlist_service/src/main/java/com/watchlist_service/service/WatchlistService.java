package com.watchlist_service.service;



import com.coin_service.entity.Coin;
import com.watchlist_service.entity.NewWatchlistDTO;
import com.watchlist_service.entity.Watchlist;
import reactor.core.publisher.Mono;

import java.util.List;

public interface WatchlistService {

    Watchlist createWatchlist(NewWatchlistDTO newWatchlistDTO);

    List<Watchlist> getAllWatchlists();

    Watchlist getWatchlistById(Long id);

    void deleteWatchlistById(Long id);

    Watchlist renameWatchlist(Long id, String newName);

    Coin fetchCoinFromDatabaseByCoinId(String coinId);

    Watchlist addCoinToWatchlist(Long id, String coinId);

    void deleteCoinFromWatchlist(Long id ,String coinId);
}
