package com.watchlist_service.service;

import com.watchlist_service.entity.NewWatchlistDTO;
import com.watchlist_service.entity.Watchlist;
import com.watchlist_service.exception.WatchlistNotFoundException;
import com.watchlist_service.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    private final WatchlistRepository watchlistRepository;

    public WatchlistServiceImpl(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    @Override
    public Watchlist createWatchlist(NewWatchlistDTO newWatchlistDTO) {
        Watchlist watchlist = new Watchlist();

        watchlist.setWatchlistName(newWatchlistDTO.getWatchlistName());
        watchlist.setFiatCurrency(newWatchlistDTO.getFiatCurrency());
        watchlist.setUserId(1L);

        return watchlistRepository.save(watchlist);
    }

    @Override
    public List<Watchlist> getAllWatchlists() {
        return watchlistRepository.findAll();
    }

    @Override
    public Watchlist getWatchlistById(Long id) {
        return watchlistRepository.findById(id)
                .orElseThrow(() -> new WatchlistNotFoundException(id));
    }

    @Override
    public void deleteWatchlistById(Long id) {
        if(!watchlistRepository.existsById(id)) {
            throw new WatchlistNotFoundException(id);
        }
        watchlistRepository.deleteById(id);
    }

    @Override
    public Watchlist renameWatchlist(Long id, String newName) {
        String updatedName = newName.trim();
        Watchlist watchlist = getWatchlistById(id);
        watchlist.setWatchlistName(updatedName);
        return watchlistRepository.save(watchlist);
    }

}
