package com.octopus.pb.controller;


import com.octopus.pb.testdata.BuildData;
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

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Slf4j
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/db-wipe.sql")
public class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BuildData buildData;


    @Test
    public void contextLoads() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    public void testGetAll() throws Exception {

        final String actual = "[{\"id\":1,\"name\":\"Some Event\",\"info\":\"Info about event\",\"shortInfo\":null,\"gameRules\":null,\"capacity\":888,\"beginDate\":\"2018-05-20T10:00:00\",\"endDate\":\"2018-05-20T18:00:00\",\"field\":{\"id\":1,\"name\":\"Field1\",\"info\":\"Info about field1\",\"type\":null,\"size\":null,\"capacity\":100,\"address\":\"City, Street, Building\",\"rating\":{\"id\":1,\"positive\":10,\"negative\":5,\"surfaceQuality\":0,\"coverAmount\":0,\"coverQuality\":0,\"coverPlacement\":0,\"infrastructure\":0,\"staff\":0,\"rentalEquipment\":0,\"prices\":0}},\"groupMap\":{\"RED\":{\"id\":1,\"groupType\":\"RED\",\"playerSet\":[{\"id\":1,\"name\":\"dmz\",\"rank\":{\"id\":1,\"name\":\"Captain\",\"rankType\":\"PLAYER\"},\"team\":{\"id\":1,\"name\":\"Irish\",\"shortName\":null,\"teamInfo\":null,\"rank\":{\"id\":3,\"name\":\"11\",\"rankType\":\"TEAM\"}}}]},\"BLUE\":{\"id\":2,\"groupType\":\"BLUE\",\"playerSet\":[{\"id\":2,\"name\":\"mu8d\",\"rank\":{\"id\":2,\"name\":\"Regular\",\"rankType\":\"PLAYER\"},\"team\":{\"id\":1,\"name\":\"Irish\",\"shortName\":null,\"teamInfo\":null,\"rank\":{\"id\":3,\"name\":\"11\",\"rankType\":\"TEAM\"}}}]}},\"active\":false}]";

        buildData.buildEvent();

        String response = mockMvc.perform(get("/event/getAll"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        log.info(response);

        JSONAssert.assertEquals(actual, response, true);
    }

}
