package org.hillel.spring.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hillel.spring.config.ServiceTestConfig;
import org.hillel.spring.model.entity.Order;
import org.hillel.spring.model.mapper.OrderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
public class ServiceTestParent {
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected OrderMapper orderMapper;

    protected List<Order> testOrders;


    @BeforeEach
    void setUpParent() {
        initOrders();
    }

    private void initOrders() {
        try (final InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("orders-data.json")) {
            testOrders = objectMapper.readValue(inputStream, new TypeReference<List<Order>>() {
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
