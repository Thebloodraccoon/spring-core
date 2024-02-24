package org.hillel.spring.repo;

import org.hillel.spring.model.entity.Order;

import java.util.List;

public interface OrderRepo {
    Order save(Order order);
    Order find(Long id);
    List<Order> findAll();
    Order remove(Order order);
}
