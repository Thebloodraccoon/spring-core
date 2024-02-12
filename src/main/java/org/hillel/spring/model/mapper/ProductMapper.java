package org.hillel.spring.model.mapper;

import org.hillel.spring.model.dto.ProductDTO;
import org.hillel.spring.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    Product productDTOToProduct(ProductDTO product);
    ProductDTO productToProductDTO(Product product);
}
