package org.nsbedfw.jobboard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.nsbedfw.jobboard.controllers.requests.CandidateRequest;
import org.nsbedfw.jobboard.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class JobBoardControllerTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CandidateService candidateService;

    @Test
    void shouldCallJobBoardService() throws Exception {
        CandidateRequest candidateRequest = new CandidateRequest("firstName", "lastName", "email", "industry", "skillLevel");

        this.mockMvc.perform(post("/candidate")
                .content(objectMapper.writeValueAsString(candidateRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(candidateService, times(1)).addCandidate(candidateRequest);
    }
}