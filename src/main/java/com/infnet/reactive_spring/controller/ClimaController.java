package com.infnet.reactive_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infnet.reactive_spring.service.ClimaService;

import reactor.core.publisher.Mono;

public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping("/clima/{cidade}")
    public Mono<String> buscarClima(@PathVariable String cidade) {
        return climaService.buscarClima(cidade);
    }
}
