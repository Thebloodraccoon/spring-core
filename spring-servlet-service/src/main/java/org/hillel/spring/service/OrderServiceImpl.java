package org.hillel.spring.service;

import lombok.RequiredArgsConstructor;
import org.hillel.spring.model.dto.OrderDTO;
import org.hillel.spring.model.entity.Order;
import org.hillel.spring.model.mapper.OrderMapper;
import org.hillel.spring.repo.OrderJpaRepo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Scope("prototype")
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderJpaRepo orderRepo;
    private final OrderMapper orderMapper;

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = orderMapper.orderDtoToOrder(orderDTO);

        Order save = orderRepo.save(order);
        return orderMapper.orderToOrderDTO(save);
    }

    @Override
    public OrderDTO deleteOrder(OrderDTO orderDTO) {
        Order order = orderMapper.orderDtoToOrder(orderDTO);

        orderRepo.delete(order);

        return orderMapper.orderToOrderDTO(order);
    }

    @Override
    public OrderDTO getOrder(Long id) {
        Order order = orderRepo.findById(id).get();

        return orderMapper.orderToOrderDTO(order);
    }

    @Override
    public List<OrderDTO> getOrders() {
        List<Order> all = orderRepo.findAll();

        return all.stream()
                .map(orderMapper::orderToOrderDTO)
                .toList();
    }
}
