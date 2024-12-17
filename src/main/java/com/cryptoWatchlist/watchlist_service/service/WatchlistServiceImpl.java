package com.cryptoWatchlist.watchlist_service.service;

import com.cryptoWatchlist.watchlist_service.entity.Watchlist;
import com.cryptoWatchlist.watchlist_service.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

@Service
public class WatchlistServiceImpl implements WatchlistService{

    private final WatchlistRepository watchlistRepository;

    public WatchlistServiceImpl(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    @Override
    public Watchlist createWatchlist(Watchlist watchlist) {
        return watchlistRepository.save(watchlist);
    }
}
