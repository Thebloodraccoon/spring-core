package org.hillel.spring.model.mapper;


import org.hillel.spring.model.dto.OrderDTO;
import org.hillel.spring.model.dto.ProductDTO;
import org.hillel.spring.model.entity.Order;
import org.hillel.spring.model.entity.Product;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderMapperTest extends MapperTestParent {
    @Test
    public void testOrderToOrderDTO() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());


        Order order = new Order();
        order.setId(1L);
        order.setCost(100.0);
        order.setData(LocalDate.of(2024, 2, 24));
        order.setProducts(products);


        OrderDTO orderDTO = orderMapper.orderToOrderDTO(order);

        assertEquals(order.getId(), orderDTO.getId());
        assertEquals(order.getCost(), orderDTO.getCost());
        assertEquals(order.getData(), orderDTO.getData());
        assertEquals(order.getProducts().size(), orderDTO.getProducts().size());
    }

    @Test
    public void testOrderDtoToOrder() {
        List<ProductDTO> productsDTO = new ArrayList<>();
        productsDTO.add(new ProductDTO());

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(1L);
        orderDTO.setCost(100.0);
        orderDTO.setData(LocalDate.of(2024, 2, 24));
        orderDTO.setProducts(productsDTO);

        Order order = orderMapper.orderDtoToOrder(orderDTO);

        assertEquals(orderDTO.getId(), order.getId());
        assertEquals(orderDTO.getCost(), order.getCost());
        assertEquals(orderDTO.getData(), order.getData());
        assertEquals(orderDTO.getProducts().size(), order.getProducts().size());
    }
}