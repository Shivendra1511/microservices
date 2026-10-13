package com.example.api_gateway;

import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;
import org.slf4j.Logger;
@Component
public class LoggingFilter implements GlobalFilter {
    private Logger logger= (Logger) LoggerFactory.getLogger(LoggingFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Path of the request is {}" ,exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
