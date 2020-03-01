package org.nsbedfw.jobboard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.nsbedfw.jobboard.controllers.requests.CandidateRequest;
import org.nsbedfw.jobboard.domain.Candidate;
import org.nsbedfw.jobboard.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static java.util.Collections.singletonList;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.*;
import static org.nsbedfw.jobboard.testUtilities.DummyData.dummyCandidate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    void shouldCallCandidateService() throws Exception {
        CandidateRequest candidateRequest = new CandidateRequest("1234","firstName", "lastName", "email", "industry", "skillLevel");
        this.mockMvc.perform(post("/candidates")
                .content(objectMapper.writeValueAsString(candidateRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(candidateService, times(1)).addCandidate(candidateRequest.toCandidate());
    }

    @Test
    void shouldCallGetCandidates() throws Exception {
        when(candidateService.getAllCandidates()).thenReturn(singletonList(dummyCandidate()));


       mockMvc.perform(get("/candidates")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Goodness"))
                .andExpect(jsonPath("$[0].lastName").value("Daramola"))
                .andExpect(jsonPath("$[0].email").value("email@test.com"))
                .andExpect(jsonPath("$[0].skillLevel").value("entry"))
                .andExpect(jsonPath("$[0].industry").value("Software"));
    }

    @Test
    void shouldDeleteCandidate() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("candidateId", singletonList("1234"));

        mockMvc.perform(delete("/candidates")
               .params(params)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(candidateService, times(1)).delete("1234");
    }
}