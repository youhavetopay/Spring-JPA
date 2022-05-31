package com.example.springjpaproject;

import com.example.springjpaproject.user.controller.TestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class TestControllerTests {

  @InjectMocks
  private TestController testController;

  MockMvc mvc;

  @BeforeEach
  public void init() {
    mvc = MockMvcBuilders.standaloneSetup(testController).build();
  }

  @Test
  @DisplayName("/test api 테스트")
  public void getTestResult() throws Exception {

    this.mvc.perform(
            MockMvcRequestBuilders.get("/test")
        ).andExpect(status().isOk())
        .andExpect(content().json("{'GROUP_NAME':'IZONE'}"));

  }


}
