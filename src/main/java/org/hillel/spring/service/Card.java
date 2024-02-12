package org.hillel.spring.service;

import org.hillel.spring.model.dto.ProductDTO;

import java.util.List;

public interface Card {
    ProductDTO addProduct(ProductDTO product);
    ProductDTO deleteProduct(Long id);
    ProductDTO getProduct(Long id);
    List<ProductDTO> getProducts();
}
