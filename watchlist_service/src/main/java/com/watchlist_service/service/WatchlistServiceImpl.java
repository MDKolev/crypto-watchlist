package com.watchlist_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.exception.CoinNotFoundException;
import com.watchlist_service.entity.NewWatchlistDTO;
import com.watchlist_service.entity.Watchlist;
import com.watchlist_service.exception.WatchlistAlreadyExistException;
import com.watchlist_service.exception.WatchlistContainThisCoinException;
import com.watchlist_service.exception.WatchlistNotFoundException;
import com.watchlist_service.repository.WatchlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    private final String COINS_URL = "http://localhost:8081/api/coins";

    private final WatchlistRepository watchlistRepository;

    private final RestTemplate restTemplate;

    public WatchlistServiceImpl(WatchlistRepository watchlistRepository, RestTemplate restTemplate) {
        this.watchlistRepository = watchlistRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Watchlist createWatchlist(NewWatchlistDTO newWatchlistDTO) {
        Watchlist checkForWatchlist = watchlistRepository.findByWatchlistName(newWatchlistDTO.getWatchlistName());
        String watchlistName = checkForWatchlist.getWatchlistName();

        if (!watchlistName.isEmpty()) {
            throw new WatchlistAlreadyExistException(newWatchlistDTO.getWatchlistName());
        }

        Watchlist watchlist = new Watchlist();

        watchlist.setWatchlistName(newWatchlistDTO.getWatchlistName());
        watchlist.setFiatCurrency(newWatchlistDTO.getFiatCurrency());
        watchlist.setUserId(1L);
        Set<String> newListOfCoins = new HashSet<>();
        watchlist.setCoins(newListOfCoins);

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

    @Override
    public Coin fetchCoinFromDatabaseByCoinId(String coinId) {
        String url = String.format("%s/%s", COINS_URL, coinId);

        try {
            return restTemplate.getForEntity(url, Coin.class).getBody();
        } catch (HttpClientErrorException exception) {
            throw new CoinNotFoundException(coinId);
        }
    }

    @Override
    public Watchlist addCoinToWatchlist(Long id, String coinId) {
        Watchlist watchlist = getWatchlistById(id);
        Set<String> coins = watchlist.getCoins();
        watchlist.setCoins(checkIfCoinIsAdded(coins,coinId));
        watchlistRepository.save(watchlist);
        return watchlist;
    }

    @Override
    public void deleteCoinFromWatchlist(Long id, String coinId) {
        Watchlist watchlist = getWatchlistById(id);
        Set<String> coins = watchlist.getCoins();

        if (coins.contains(coinId)) {
            coins.remove(coinId);
            watchlist.setCoins(coins);
            watchlistRepository.save(watchlist);
        } else {
            throw new CoinNotFoundException(coinId);
        }
    }

    public Set<String> checkIfCoinIsAdded(Set<String> watchlistCoins, String coin) {
        Set<String> coins = new HashSet<>(watchlistCoins);

        if (!coins.contains(coin)){
            coins.add(coin);
            return coins;
        } else {
            throw new WatchlistContainThisCoinException(coin);
        }
    }
}
