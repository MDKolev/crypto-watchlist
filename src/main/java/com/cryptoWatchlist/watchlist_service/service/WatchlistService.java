package com.cryptoWatchlist.watchlist_service.service;

import com.cryptoWatchlist.watchlist_service.entity.Watchlist;

import java.util.List;

public interface WatchlistService {

    Watchlist createWatchlist(Watchlist watchlistName);

    List<Watchlist> getAllWatchlists();

    Watchlist getWatchlistById(long id);

    void deleteWatchlistById(long id);

    Watchlist renameWatchlist(long id, String newName);
}
