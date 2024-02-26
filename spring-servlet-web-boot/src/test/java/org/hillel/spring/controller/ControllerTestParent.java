package org.hillel.spring.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hillel.spring.config.ControllerTestConfig;
import org.hillel.spring.exception.GlobalExceptionHandler;
import org.hillel.spring.model.dto.OrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ControllerTestConfig.class})
public class ControllerTestParent {
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected GlobalExceptionHandler globalExceptionHandler;
    protected MockMvc mockMvc;
    protected List<OrderDTO> testOrders;


    @BeforeEach
    void setUpParent() {
        initOrders();
    }

    private void initOrders() {
        try (final InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("orders-data.json")) {
            testOrders = objectMapper.readValue(inputStream, new TypeReference<List<OrderDTO>>() {
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
