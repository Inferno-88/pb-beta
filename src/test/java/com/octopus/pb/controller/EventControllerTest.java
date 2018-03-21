package com.octopus.pb.controller;


import com.octopus.pb.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
@ActiveProfiles("test")
@Slf4j
public class EventControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EventService service;

    @Test
    public void testGetAll() {

    }

}
