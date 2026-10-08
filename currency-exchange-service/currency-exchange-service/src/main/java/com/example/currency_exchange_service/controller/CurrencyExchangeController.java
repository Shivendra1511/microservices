package com.example.currency_exchange_service.controller;

import com.example.currency_exchange_service.model.CurrencyExchange;
import com.example.currency_exchange_service.service.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {
    private Environment environment;
    private CurrencyExchangeService service;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveCurrenct(@PathVariable String from, @PathVariable String to){
        CurrencyExchange currencyExchange=service.findByFromAndTo(from,to);
        currencyExchange.setEnv(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
