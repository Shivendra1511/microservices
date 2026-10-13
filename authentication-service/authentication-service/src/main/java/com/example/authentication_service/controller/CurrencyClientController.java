package com.example.authentication_service.controller;

import com.example.authentication_service.model.CurrencyExchangeClients;
import com.example.authentication_service.model.NewCurrencyExchangeClient;
import com.example.authentication_service.service.CurrencyClientservice;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@AllArgsConstructor
public class CurrencyClientController {
    private CurrencyClientservice clientservice;
    private JwtEncoder jwtEncoder;
    @PostMapping("/register")
    public ResponseEntity<CurrencyExchangeClients> newUser(@RequestBody NewCurrencyExchangeClient client){
        return clientservice.createClients(client);
    }
    @GetMapping("/test")
    public String check(){
        return "kaise ho";
    }
    @PostMapping("/authenticate")
    public String token(Authentication authentication){
        JwtClaimsSet claimsSet= JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60*30))
                .subject(authentication.getName())
                .build();
        JwtEncoderParameters jwtEncoderParameters=JwtEncoderParameters.from(claimsSet);
        return jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
    }
}
