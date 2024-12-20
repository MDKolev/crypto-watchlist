package com.coin_service.mapper;

import com.coin_service.entity.Coin;

import java.util.Map;

public class ManualMapper {

    public Coin mapObjectToCoin(Object obj) {
        Map<String, Object> map = (Map<String, Object>) obj;
        Coin coin = new Coin();
        coin.setApi_id((String) map.get("id"));
        coin.setName((String) map.get("name"));
        coin.setSymbol((String) map.get("symbol"));

        Number currentPrice = (Number) map.get("current_price");
        if (currentPrice != null) {
            coin.setCurrentPrice(currentPrice.doubleValue());
        }
        coin.setPriceChange24h((Double) map.get("price_change_24h"));
        coin.setPercentageChange24h((Double) map.get("price_change_percentage_24h"));

        return coin;
    }
}
