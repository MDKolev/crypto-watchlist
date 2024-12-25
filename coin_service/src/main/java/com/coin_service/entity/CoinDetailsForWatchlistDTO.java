package com.coin_service.entity;

public record CoinDetailsForWatchlistDTO(String name, String symbol, Number current_price, Number price_change_24h, Number price_change_percentage_24h) {
}
