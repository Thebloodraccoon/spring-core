package org.hillel.spring.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hillel.spring.model.entity.Product;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDate data;
    private Double cost;
    private List<ProductDTO> products;
}
