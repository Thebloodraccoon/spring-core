package org.hillel.spring;

import org.hillel.spring.model.dto.ProductDTO;
import org.hillel.spring.service.Card;
import org.hillel.spring.service.CardService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext("org.hillel.spring");

        Card card = annotationContext.getBean(CardService.class);

        Card card1 = annotationContext.getBean(CardService.class);
        Card card2 = annotationContext.getBean(CardService.class);

        List<ProductDTO> products = card.getProducts();
        System.out.println(products);

        ProductDTO home = new ProductDTO();
        home.setName("home");
        home.setCost(2334.2);

        card.addProduct(home);

        ProductDTO product = card.getProduct(9L);

        System.out.println("ID 9: " + product);

        ProductDTO productDTO = card.deleteProduct(9L);
        System.out.println("Deleting with ID 9");


        List<ProductDTO> products1 = card.getProducts();
        System.out.println(products1);
    }
}