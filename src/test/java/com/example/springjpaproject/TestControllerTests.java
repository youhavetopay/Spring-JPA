package com.example.springjpaproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestControllerTests {

    @InjectMocks
    private TestController testController;

    MockMvc mvc;

    @BeforeEach
    public void init(){
        mvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    @DisplayName("/test api 테스트")
    public void  getTestResult() throws Exception {

        MvcResult result  = mvc.perform(
                MockMvcRequestBuilders.get("/test")
        ).andReturn();

        assertEquals("Hello Docker World", result.getResponse().getContentAsString());

    }
}
