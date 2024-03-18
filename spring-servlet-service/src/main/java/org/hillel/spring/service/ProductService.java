package org.hillel.spring.service;

import org.hillel.spring.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO deleteById(Long id);

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    ProductDTO save(ProductDTO product);
}
