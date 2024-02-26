package org.hillel.spring.controller;


import org.hillel.spring.model.dto.OrderDTO;
import org.hillel.spring.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrderControllerTest extends ControllerTestParent {
    @Mock
    private OrderService orderServiceMock;
    private OrderController orderController;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        orderController = new OrderController(orderServiceMock);

        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController)
                .setControllerAdvice(globalExceptionHandler)
                .build();
    }



    @Test
    public void getAllOrdersTest_success() throws Exception {
        when(orderServiceMock.getOrders()).thenReturn(testOrders);

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getAllOrderByIDTest_success() throws Exception {
        when(orderServiceMock.getOrder(anyLong())).thenReturn(testOrders.get(0));

        Long testId = 1L;

        mockMvc.perform(get("/orders/" + testId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createOrderTest_success() throws Exception {
        when(orderServiceMock.addOrder(any())).thenReturn(testOrders.get(0));

        final OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCost(200.0);
        orderDTO.setProducts(new ArrayList<>());


        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteOrderTest_success() throws Exception {
        when(orderServiceMock.deleteOrder(any())).thenReturn(testOrders.get(0));

        final OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCost(200.0);
        orderDTO.setProducts(new ArrayList<>());


        mockMvc.perform(delete("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}