package org.hillel.spring.service;


import org.hillel.spring.model.dto.OrderDTO;
import org.hillel.spring.repo.OrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest extends ServiceTestParent {
    @Mock
    private OrderRepo orderRepoMock;
    private OrderService orderService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        orderService = new OrderServiceImpl(orderRepoMock, orderMapper);
    }

    @Test
    public void getAllOrdersTest_success() {
        when(orderRepoMock.findAll()).thenReturn(testOrders);

        final List<OrderDTO> allOrder = orderService.getOrders();

        assertNotNull(allOrder);
        assertNotEquals(allOrder.size(), 0);
    }

    @Test
    public void getOrderByIdTest_success(){
        Long testId = 1L;

        when(orderRepoMock.find(anyLong())).thenReturn(testOrders.get(0));

        OrderDTO orderById = orderService.getOrder(testId);

        assertNotNull(orderById);
        assertNotNull(orderById.getId());
    }

    @Test
    public void deleteOrderTest_success() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(1L);

        when(orderRepoMock.remove(any())).thenReturn(testOrders.get(0));

        OrderDTO deletedOrder = orderService.deleteOrder(orderDTO);
        assertNotNull(deletedOrder);
        assertNotNull(deletedOrder.getId());
        assertEquals(orderDTO.getId(), deletedOrder.getId());
    }

    @Test
    public void addOrderTest_success() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(1L);

        when(orderRepoMock.save(any())).thenReturn(testOrders.get(0));

        OrderDTO savedOrder = orderService.addOrder(orderDTO);
        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        assertEquals(orderDTO.getId(), savedOrder.getId());
    }
}