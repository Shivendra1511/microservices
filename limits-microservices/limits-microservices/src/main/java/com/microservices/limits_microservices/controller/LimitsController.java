package com.microservices.limits_microservices.controller;

import com.microservices.limits_microservices.bean.Limits;
import com.microservices.limits_microservices.configuration.Config;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LimitsController {
    private Config config;
    @GetMapping("/limits")
    public Limits limits(){
        return new Limits(config.getMinimum(),config.getMaximum());
    }

}
