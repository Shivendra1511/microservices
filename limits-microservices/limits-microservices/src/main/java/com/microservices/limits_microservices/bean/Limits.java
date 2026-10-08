package com.microservices.limits_microservices.bean;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Limits {
    private int min;
    private int max;
}
