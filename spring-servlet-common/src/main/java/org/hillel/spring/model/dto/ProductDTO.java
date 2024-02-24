package org.hillel.spring.model.dto;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double cost;
}
