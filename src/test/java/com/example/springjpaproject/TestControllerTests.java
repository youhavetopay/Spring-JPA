package com.example.springjpaproject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
public class TestControllerTests {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("/test api 테스트")
    public void  getTestResult(){

    }
}
