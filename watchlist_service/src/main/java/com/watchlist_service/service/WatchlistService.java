package com.watchlist_service.service;



import com.watchlist_service.entity.NewWatchlistDTO;
import com.watchlist_service.entity.Watchlist;

import java.util.List;

public interface WatchlistService {

    Watchlist createWatchlist(NewWatchlistDTO newWatchlistDTO);

    List<Watchlist> getAllWatchlists();

    Watchlist getWatchlistById(Long id);

    void deleteWatchlistById(Long id);

    Watchlist renameWatchlist(Long id, String newName);
}
