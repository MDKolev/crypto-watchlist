package com.watchlist_service.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "user_id")
    private Long userId;

    @Column(unique = true, nullable = false, name = "watchlist_name")
    private String watchlistName;

    @Column()
    private Set<String> coins;

    @Enumerated(EnumType.STRING)
    @Column(name = "fiat_currency", nullable = false)
    private FiatCurrency fiatCurrency = FiatCurrency.USD;

    public Watchlist() {
    }

    public Watchlist(Long id, Long userId, String watchlistName, Set<String> coins, FiatCurrency fiatCurrency) {
        this.id = id;
        this.userId = userId;
        this.watchlistName = watchlistName;
        this.coins = coins;
        this.fiatCurrency = fiatCurrency != null ? fiatCurrency : FiatCurrency.USD;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWatchlistName() {
        return watchlistName;
    }

    public void setWatchlistName(String watchlistName) {
        this.watchlistName = watchlistName;
    }

    public Set<String> getCoins() {
        return coins;
    }

    public void setCoins(Set<String> coins) {
        this.coins = coins;
    }

    public FiatCurrency getFiatCurrency() {
        return fiatCurrency;
    }

    public void setFiatCurrency(FiatCurrency fiatCurrency) {
        this.fiatCurrency = fiatCurrency !=null ? fiatCurrency : FiatCurrency.USD;
    }
}
