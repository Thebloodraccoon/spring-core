package org.hillel.spring.service;

import org.hillel.spring.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO addOrder(OrderDTO orderDTO);
    OrderDTO deleteOrder(OrderDTO orderDTO);
    OrderDTO getOrder(Long id);
    List<OrderDTO> getOrders();
}
