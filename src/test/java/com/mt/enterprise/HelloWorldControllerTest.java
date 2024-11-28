package com.mt.enterprise;

import com.mt.enterprise.controller.HelloWorldController;
import com.mt.enterprise.service.SomeService;  // Import the service
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(HelloWorldController.class)  // Test only the HelloWorldController
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;  // MockMvc for making HTTP requests

    @MockBean
    private SomeService someService;  // Mock the SomeService dependency

    @Test
    public void testHelloWorld() throws Exception {
        // Mock the behavior of SomeService
        given(someService.getMessage()).willReturn("Hello, welcome to the Maven Enterprise Application!");

        mockMvc.perform(get("/hello"))  // Perform a GET request to the "/hello" endpoint
                .andExpect(status().isOk())  // Expect HTTP status 200 (OK)
                .andExpect(content().string("Hello, welcome to the Maven Enterprise Application!"));  // Expect the response content
    }
}
