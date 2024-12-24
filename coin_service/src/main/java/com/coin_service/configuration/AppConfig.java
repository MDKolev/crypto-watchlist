package com.coin_service.configuration;

import com.coin_service.mapper.ManualMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("https://api.coingecko.com/api/v3").build();
    }

    @Bean
    public ManualMapper manualMapper(){
        return  new ManualMapper();
    }
}
