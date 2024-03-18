package org.hillel.spring.service;


import lombok.AllArgsConstructor;
import org.hillel.spring.model.dto.OrderDTO;
import org.hillel.spring.model.dto.ProductDTO;
import org.hillel.spring.model.entity.Order;
import org.hillel.spring.model.entity.Product;
import org.hillel.spring.model.mapper.ProductMapper;
import org.hillel.spring.repo.ProductJpaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductJpaRepo productRepo;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productMapper.productDtoToProduct(productDTO);

        Product save = productRepo.save(product);
        return productMapper.productToProductDTO(save);
    }

    @Override
    public ProductDTO deleteById(Long id) {
        Product product = productRepo.findById(id).get();
        productRepo.delete(product);

        return productMapper.productToProductDTO(product);
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepo.findById(id).get();

        return productMapper.productToProductDTO(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> all = productRepo.findAll();

        return all.stream()
                .map(productMapper::productToProductDTO)
                .toList();
    }
}
