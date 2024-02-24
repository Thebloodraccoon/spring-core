package org.hillel.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity ping() {
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable int id) {
        return "Order ID: " + id;
    }
}
