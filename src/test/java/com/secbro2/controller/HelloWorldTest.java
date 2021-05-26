package com.secbro2.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Molly Huang
 * @param
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        //mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testHello() throws Exception {
        //mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andDo(print());         // 簡單打印
        //mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("name", "molly"))  // 加參數時
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())     // 200
                .andExpect(content().string(equalTo("Hello World!")))   // body
                .andDo(MockMvcResultHandlers.print());  // 打印
    }
}
