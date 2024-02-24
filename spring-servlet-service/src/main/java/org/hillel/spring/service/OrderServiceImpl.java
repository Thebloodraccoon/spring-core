package org.hillel.spring.service;

import lombok.RequiredArgsConstructor;
import org.hillel.spring.model.dto.OrderDTO;
import org.hillel.spring.model.entity.Order;
import org.hillel.spring.model.mapper.OrderMapper;
import org.hillel.spring.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Scope("prototype")
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo productRepo;
    private final OrderMapper productMapper;

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = productMapper.orderDtoToOrder(orderDTO);

        Order save = productRepo.save(order);
        return productMapper.orderToOrderDTO(save);
    }

    @Override
    public OrderDTO deleteOrder(OrderDTO orderDTO) {
        Order order = productMapper.orderDtoToOrder(orderDTO);

        Order remove = productRepo.remove(order);

        return productMapper.orderToOrderDTO(remove);
    }

    @Override
    public OrderDTO getOrder(Long id) {
        Order order = productRepo.find(id);

        return productMapper.orderToOrderDTO(order);
    }

    @Override
    public List<OrderDTO> getOrders() {
        List<Order> all = productRepo.findAll();

        return all.stream()
                .map(productMapper::orderToOrderDTO)
                .toList();
    }
}
