package org.hillel.spring.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping()
    public String ping(Authentication authentication) {
        return "OK";
    }
}
