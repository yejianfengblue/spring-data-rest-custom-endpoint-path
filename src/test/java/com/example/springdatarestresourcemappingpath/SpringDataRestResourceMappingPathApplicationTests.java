package com.example.springdatarestresourcemappingpath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringDataRestResourceMappingPathApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    @Test
    void testUserGreetingEndpoint() throws Exception {

        mockMvc.perform(
                get("/users/1/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("\"Hello Alice\""));
    }

    @Test
    void testGetBasePath() {

        assertThat(repositoryRestConfiguration.getBasePath().getPath())
                .isEqualTo("/api");
    }

}
