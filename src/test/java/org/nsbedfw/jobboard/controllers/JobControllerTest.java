package org.nsbedfw.jobboard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.nsbedfw.jobboard.controllers.requests.JobRequest;
import org.nsbedfw.jobboard.domain.Job;
import org.nsbedfw.jobboard.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.nsbedfw.jobboard.testUtilities.DummyData.dummyJob;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class JobControllerTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobService jobService;

    @Test
    void shouldCallJobService() throws Exception {
        JobRequest jobRequest = new JobRequest(
                "Software Developer",
                "ThoughtWorks",
                "Tech",
                "Junior",
                Collections.emptyList());

        this.mockMvc.perform(post("/jobs")
                .content(objectMapper.writeValueAsString(jobRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ArgumentCaptor<Job> actual = ArgumentCaptor.forClass(Job.class);
        verify(jobService, times(1)).addJob(actual.capture());

        Job expected = new Job(
                UUID.randomUUID(),
                "Software Developer",
                "ThoughtWorks",
                "Tech",
                "Junior",
                Collections.emptyList());
        assertThat(actual.getValue()).isEqualToIgnoringGivenFields(expected, "id");
    }

    @Test
    void shouldCallGetJobs() throws Exception {
        when(jobService.getAllJobs()).thenReturn(singletonList(dummyJob()));

        mockMvc.perform(get("/jobs")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Software Developer"))
                .andExpect(jsonPath("$[0].companyName").value("ThoughtWorks"))
                .andExpect(jsonPath("$[0].industry").value("Tech"))
                .andExpect(jsonPath("$[0].skillLevel").value("Junior"))
                .andExpect(jsonPath("$[0].skills").isEmpty());
    }

    @Test
    void shouldDeleteJob() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("jobId", singletonList("1234"));

        mockMvc.perform(delete("/jobs")
                .params(params)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(jobService, times(1)).delete("1234");
    }

}
