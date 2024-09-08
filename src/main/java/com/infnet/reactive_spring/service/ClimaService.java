package com.infnet.reactive_spring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ClimaService {

    private final WebClient webClient;

    public ClimaService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org").build();
    }

    public Mono<String> buscarClima(String cidade) {
        String apiKey = "SUA_CHAVE_API";  // Substitua pela sua chave de API

        return this.webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/data/2.5/weather")
                .queryParam("q", cidade)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build())
            .retrieve()
            .bodyToMono(String.class);
    }
}