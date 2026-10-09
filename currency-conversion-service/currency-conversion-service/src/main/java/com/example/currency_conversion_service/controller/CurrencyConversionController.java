package com.example.currency_conversion_service.controller;

import com.example.currency_conversion_service.CurrencyConversionProxy;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class CurrencyConversionController {
    private Environment environment;
    private CurrencyConversionProxy proxy;
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversion(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
        HashMap<String, String> uriVariables=new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversion> resEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}"
                , CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion=resEntity.getBody();
        return new CurrencyConversion(
                currencyConversion.getId(),
                from,
                to,
                currencyConversion.getConversionMultiple(),
                quantity,
                quantity.multiply( currencyConversion.getConversionMultiple()),
                currencyConversion.getEnv() + " " + "RestTemplate");
    }

    @GetMapping("/currency-conversionfeign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversionfeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        CurrencyConversion currencyConversion=proxy.retriveCurrenct(from,to);
        return new CurrencyConversion(
                currencyConversion.getId(),
                from,
                to,
                currencyConversion.getConversionMultiple(),
                quantity,
                quantity.multiply( currencyConversion.getConversionMultiple()),
                currencyConversion.getEnv() + " " + "feignClients");
    }
}
