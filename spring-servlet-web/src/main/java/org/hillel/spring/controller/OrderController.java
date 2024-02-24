package org.hillel.spring.controller;

import org.hillel.spring.model.dto.OrderDTO;
import org.hillel.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getOrders();

        return ResponseEntity.ok(orders);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<OrderDTO> getOrder(@PathVariable long id) {
        OrderDTO order = orderService.getOrder(id);

        return ResponseEntity.ok(order);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO saved = orderService.addOrder(orderDTO);

        return ResponseEntity.ok(saved);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<OrderDTO> deleteOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO deletedOrder = orderService.deleteOrder(orderDTO);

        return ResponseEntity.ok(deletedOrder);
    }
}
