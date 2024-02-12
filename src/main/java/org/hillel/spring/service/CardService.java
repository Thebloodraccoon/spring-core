package org.hillel.spring.service;


import lombok.RequiredArgsConstructor;
import org.hillel.spring.model.dto.ProductDTO;
import org.hillel.spring.model.entity.Product;
import org.hillel.spring.model.mapper.ProductMapper;
import org.hillel.spring.repo.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;



import java.util.List;

@Primary
@RequiredArgsConstructor
@Service
@Scope("prototype")
public class CardService implements Card {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        productRepo.save(product);

        return productMapper.productToProductDTO(product);
    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        Product product = productRepo.find(id);
        Product remove = productRepo.remove(product);

        return productMapper.productToProductDTO(remove);
    }

    @Override
    public ProductDTO getProduct(Long id) {
        Product product = productRepo.find((Long) id);
        return productMapper.productToProductDTO(product);
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> all = productRepo.findAll();

        return all.stream()
                .map(productMapper::productToProductDTO)
                .toList();
    }
}
