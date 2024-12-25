package com.alert_service.service;

import com.alert_service.repository.AlertRepository;
import com.coin_service.entity.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AlertServiceImplTest {


    @Mock
    private AlertServiceImpl alertServiceImpl;

    @Mock
    private AlertRepository alertRepository;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @BeforeEach
    void setUp() {
        alertServiceImpl = new AlertServiceImpl(alertRepository, webClient);
    }


    @Test
    public void fetchCoinByIdShouldReturnCoinWhenSuccessful() {
        String coinId = "bitcoin";
        Coin mockCoin = new Coin("bitcoin", "btc", "Bitcoin", 94416,
                1868776705, 1, 198193939, 451766311,
                95570, 90809, 3606.97, 3.97205,
                70678992, 3.93076, 19800965,
                21000000, 21000000, 102938, -8.52673,
                "2024-12-17T15:02:41.429Z", 51.3, 183454,
                "2013-07-05T00:00:00.000Z", "2024-12-25T13:18:40.943Z");

        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("/{id}", coinId)).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Coin.class)).thenReturn(Mono.just(mockCoin));

        Mono<Coin> result = alertServiceImpl.fetchCoinById(coinId);

        StepVerifier.create(result)
                .expectNext(mockCoin)
                .verifyComplete();
    }

}