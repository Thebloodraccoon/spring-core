package org.hillel.spring.repo;

import org.hillel.spring.model.entity.Product;

import java.util.List;

public interface ProductRepo {
    Product save(Product product);
    Product find(Long id);
    List<Product> findAll();
    Product remove(Product product);
}
