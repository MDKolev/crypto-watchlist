package com.watchlist_service.service;

import com.coin_service.entity.Coin;
import com.coin_service.exception.CoinNotFoundException;
import com.watchlist_service.entity.NewWatchlistDTO;
import com.watchlist_service.entity.Watchlist;
import com.watchlist_service.exception.WatchlistNotFoundException;
import com.watchlist_service.repository.WatchlistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

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
        List<String> newListOfCoins = new ArrayList<>();
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
                    List<String> coins = watchlist.getCoins();
                    coins.add(coinId);
                    watchlistRepository.save(watchlist);
                    return Mono.just(watchlist);
                });
    }
}
