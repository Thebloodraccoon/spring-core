package org.hillel.spring.repo;

import org.hillel.spring.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepo extends JpaRepository<Product, Long> {
}
