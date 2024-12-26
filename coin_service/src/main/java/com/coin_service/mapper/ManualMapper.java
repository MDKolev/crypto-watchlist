package com.coin_service.mapper;

import com.coin_service.entity.Coin;
import com.coin_service.entity.CoinDetailsForWatchlistDTO;

public class ManualMapper {

    public CoinDetailsForWatchlistDTO mapCoinToCoinDetailsForWatchlistDTO(Coin coin) {
        return new CoinDetailsForWatchlistDTO(coin.getName(),
                coin.getSymbol(),
                coin.getCurrent_price(),
                coin.getPrice_change_24h(),
                coin.getPrice_change_percentage_24h());
    };

}
