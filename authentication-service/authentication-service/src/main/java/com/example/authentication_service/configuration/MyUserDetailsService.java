package com.example.authentication_service.configuration;

import com.example.authentication_service.model.CurrencyExchangeClients;
import com.example.authentication_service.repo.CurrencyExchangeRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private CurrencyExchangeRepo repo;
    @Override
    public UserDetails loadUserByUsername(String clientname) throws UsernameNotFoundException {
        CurrencyExchangeClients currencyExchangeClients=repo.findByclientname(clientname);
        if(currencyExchangeClients==null){
            throw new UsernameNotFoundException("No such user");
        }
        return User.withUsername(currencyExchangeClients.getClientname())
                .password(currencyExchangeClients.getPassword())
                .build();
    }
}
