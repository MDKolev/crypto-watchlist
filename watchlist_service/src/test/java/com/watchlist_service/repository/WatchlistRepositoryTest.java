package com.watchlist_service.repository;

import com.watchlist_service.entity.Watchlist;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WatchlistRepositoryTest {

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Test
    @Transactional
    @Rollback
    public void testFindByWatchlistNameShouldReturnCorrectWatchlist() {
      Watchlist watchlist = new Watchlist();
      watchlist.setWatchlistName("test");
      watchlist.setUserId(1L);

      watchlistRepository.save(watchlist);

      Optional<Watchlist> test = watchlistRepository.findByWatchlistName("test");
      assertNotNull(test);

      Watchlist savedWatchlist = test.get();
      assertEquals(savedWatchlist.getWatchlistName(), watchlist.getWatchlistName());
    }

}