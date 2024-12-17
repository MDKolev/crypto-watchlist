package com.cryptoWatchlist.watchlist_service.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, name = "user_id")
    private long userId;

    @Column(unique = true, nullable = false, name = "watchlist_name")
    private String watchlistName;

    @Column()
    private List<String> coins;

    public Watchlist() {
    }

    public Watchlist(long id, long userId, String watchlistName, List<String> coins) {
        this.id = id;
        this.userId = userId;
        this.watchlistName = watchlistName;
        this.coins = coins;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getWatchlistName() {
        return watchlistName;
    }

    public void setWatchlistName(String watchlistName) {
        this.watchlistName = watchlistName;
    }

    public List<String> getCoins() {
        return coins;
    }

    public void setCoins(List<String> coins) {
        this.coins = coins;
    }
}
