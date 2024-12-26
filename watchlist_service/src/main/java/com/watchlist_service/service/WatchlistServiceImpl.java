package com.watchlist_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.exception.CoinNotFoundException;
import com.watchlist_service.entity.NewWatchlistDTO;
import com.watchlist_service.entity.Watchlist;
import com.watchlist_service.exception.WatchlistContainThisCoinException;
import com.watchlist_service.exception.WatchlistNotFoundException;
import com.watchlist_service.repository.WatchlistRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    private final WatchlistRepository watchlistRepository;

    private final WebClient webClient;

    public WatchlistServiceImpl(WatchlistRepository watchlistRepository, WebClient webClient) {
        this.watchlistRepository = watchlistRepository;
        this.webClient = webClient;
    }

    @Override
    public Watchlist createWatchlist(NewWatchlistDTO newWatchlistDTO) {
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
    public Mono<Coin> fetchCoinFromDatabaseByCoinId(String coinId) {
            return webClient.get().uri("/{coinId}", coinId).retrieve()
                    .onStatus(HttpStatusCode::isError, clientResponse -> Mono.error(new CoinNotFoundException(coinId)))
                    .bodyToMono(Coin.class);
    }

    @Override
    public Mono<Watchlist> addCoinToWatchlist(Long id, String coinId) {
        return fetchCoinFromDatabaseByCoinId(coinId)
                .flatMap(coin -> {
                    Watchlist watchlist = getWatchlistById(id);
                    Set<String> coins = watchlist.getCoins();
                    checkIfCoinIsAdded(coins, coinId);
                    watchlistRepository.save(watchlist);
                    return Mono.just(watchlist);
                });
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
