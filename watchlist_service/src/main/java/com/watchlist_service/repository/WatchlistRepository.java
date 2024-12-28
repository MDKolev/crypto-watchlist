package com.watchlist_service.repository;

import com.watchlist_service.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    Watchlist findByWatchlistName(String watchlistName);
}
