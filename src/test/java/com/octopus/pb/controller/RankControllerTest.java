package com.octopus.pb.controller;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Slf4j
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/db-wipe.sql")
public class RankControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    public void testCreateRank() throws Exception {

        final String actual = "{\"id\":1,\"name\":null,\"rankType\":null}";

        String response = mockMvc.perform(post("/rank/create"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        JSONAssert.assertEquals(actual, response, true);
    }

}
