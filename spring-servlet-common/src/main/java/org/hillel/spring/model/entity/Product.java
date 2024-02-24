package org.hillel.spring.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@ToString(exclude = {"order"})
@Entity(name = "Product")
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
