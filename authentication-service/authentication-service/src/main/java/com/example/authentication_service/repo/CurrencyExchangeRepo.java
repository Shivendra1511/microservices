package com.example.authentication_service.repo;

import com.example.authentication_service.model.CurrencyExchangeClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchangeClients,Long> {
    CurrencyExchangeClients findByclientname(String clientname);
}
