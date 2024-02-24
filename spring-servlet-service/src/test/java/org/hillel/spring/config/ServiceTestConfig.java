package org.hillel.spring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hillel.spring.model.mapper.OrderMapper;
import org.hillel.spring.model.mapper.OrderMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceTestConfig {
    @Bean
    public OrderMapper orderMapper() {
        return new OrderMapperImpl();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
