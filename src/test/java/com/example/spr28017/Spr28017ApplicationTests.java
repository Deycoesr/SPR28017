package com.example.spr28017;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class Spr28017ApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test"))
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals("filterRegistrationBean", contentAsString);
    }

}
