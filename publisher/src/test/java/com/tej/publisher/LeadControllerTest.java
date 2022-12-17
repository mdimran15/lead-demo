package com.tej.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@WebMvcTest
@AutoConfigureMockMvc
public class LeadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public void testPublish() throws Exception{
        //mockMvc.perform(MockMvcRequestBuilders.post("/users")).

    }
}
