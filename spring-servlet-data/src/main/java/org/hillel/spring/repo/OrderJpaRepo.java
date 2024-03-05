package org.hillel.spring.repo;

import org.hillel.spring.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderJpaRepo extends JpaRepository<Order, Long> {
}
