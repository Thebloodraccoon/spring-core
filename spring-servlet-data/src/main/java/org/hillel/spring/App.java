package org.hillel.spring;

import org.hillel.spring.model.entity.Order;
import org.hillel.spring.repo.OrderRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext("org.hillel.spring");

        OrderRepo orderRepo = annotationContext.getBean(OrderRepo.class);

        List<Order> all = orderRepo.findAll();

        Order order = orderRepo.find(1l);

        System.out.println(order);


    }
}
