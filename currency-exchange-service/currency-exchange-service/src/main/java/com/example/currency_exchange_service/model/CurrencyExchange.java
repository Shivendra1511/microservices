package com.example.currency_exchange_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrencyExchange {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name = "currency-from")
    private String from;
    @Column(name = "currency-to")
    private String to;
    private BigDecimal conversionMultiple;
    private String env;
}
