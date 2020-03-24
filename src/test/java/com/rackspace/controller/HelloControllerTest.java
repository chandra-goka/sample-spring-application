package com.rackspace.controller;

import com.rackspace.domains.Response;
import com.rackspace.service.HelloService;
import org.hamcrest.Matchers;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(SpringRunner.class)
public class HelloControllerTest {
    private MockMvc mockMvc;
    @Mock
    HelloService helloService;
    @InjectMocks
    HelloController helloController;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(helloController)
                .build();
    }

    //Test case for Rest end point
    @Test
    public void reverse() throws Exception {
        Response response = new Response("World Hello");
        Mockito.when(helloService.reverse("Hello World")).thenReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/Hello World")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.reversed", Matchers.is("World Hello")));
        Mockito.verify(helloService).reverse("Hello World");
    }
}