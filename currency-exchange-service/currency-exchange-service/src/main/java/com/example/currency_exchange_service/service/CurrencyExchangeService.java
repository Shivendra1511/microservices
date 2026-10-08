package com.example.currency_exchange_service.service;

import com.example.currency_exchange_service.model.CurrencyExchange;
import com.example.currency_exchange_service.repo.CurrencyExchangeRepo;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyExchangeService {
    private CurrencyExchangeRepo repo;
    public CurrencyExchange findByFromAndTo(String from, String to) {
        return repo.findByFromAndTo(from,to);
    }
}
