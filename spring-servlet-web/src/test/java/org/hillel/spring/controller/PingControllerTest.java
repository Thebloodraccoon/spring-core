package org.hillel.spring.controller;

import org.junit.jupiter.api.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PingControllerTest extends ControllerTestParent {
    private PingController pingController;

    @BeforeEach
    public void setUp() {
        pingController = new PingController();

        this.mockMvc = MockMvcBuilders.standaloneSetup(pingController)
                .setControllerAdvice(globalExceptionHandler)
                .build();
    }

    @Test
    public void getAllOrdersTest_success() throws Exception {
        mockMvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }
}
