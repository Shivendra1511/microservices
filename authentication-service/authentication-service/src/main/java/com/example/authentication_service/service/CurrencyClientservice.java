package com.example.authentication_service.service;

import com.example.authentication_service.model.CurrencyExchangeClients;
import com.example.authentication_service.model.NewCurrencyExchangeClient;
import com.example.authentication_service.repo.CurrencyExchangeRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@Service
@AllArgsConstructor
public class CurrencyClientservice {
    private CurrencyExchangeRepo repo;
    private PasswordEncoder passwordEncoder;
    public ResponseEntity<CurrencyExchangeClients> createClients(NewCurrencyExchangeClient client) {
        CurrencyExchangeClients currencyExchangeClients=new CurrencyExchangeClients();
        currencyExchangeClients.setClientname(client.clientname());
        currencyExchangeClients.setPassword(passwordEncoder.encode(client.password()));
        CurrencyExchangeClients saveClient=repo.save(currencyExchangeClients);
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/find/{id}")
                .buildAndExpand(saveClient.getId())
                .toUri();
        return ResponseEntity.created(location).body(saveClient);
    }
}
