package org.hillel.spring.controller;

import lombok.RequiredArgsConstructor;
import org.hillel.spring.model.dto.ProductDTO;
import org.hillel.spring.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> all = productService.findAll();

        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ProductDTO> getOrder(@PathVariable long id) {
        ProductDTO byId = productService.findById(id);

        return ResponseEntity.ok(byId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ProductDTO> createOrder(@RequestBody ProductDTO productDTO) {
        ProductDTO save = productService.save(productDTO);

        return ResponseEntity.ok(save);
    }


    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ProductDTO> deleteOrder(@PathVariable long id) {
        ProductDTO productDTO = productService.deleteById(id);

        return ResponseEntity.ok(productDTO);
    }
}