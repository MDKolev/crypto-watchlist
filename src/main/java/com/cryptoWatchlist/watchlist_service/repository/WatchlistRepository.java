package com.cryptoWatchlist.watchlist_service.repository;

import com.cryptoWatchlist.watchlist_service.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
}
