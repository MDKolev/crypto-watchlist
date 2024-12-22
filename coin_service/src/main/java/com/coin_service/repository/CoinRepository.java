package com.coin_service.repository;

import com.coin_service.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CoinRepository extends JpaRepository<Coin, String > {


   Optional<Coin> findById(String id);
}
