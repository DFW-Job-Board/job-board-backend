package org.nsbedfw.jobboard.controllers.requests;

import org.junit.jupiter.api.Test;
import org.nsbedfw.jobboard.domain.Job;

import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class JobRequestTest {


    @Test
    void shouldTransformToJob() {
        JobRequest jobRequest = new JobRequest(
                "Software Developer",
                "ThoughtWorks",
                "Tech",
                "Junior",
                Collections.emptyList());

        Job actualJob = jobRequest.toJob();

        Job expected = new Job(
                UUID.randomUUID(),
                "Software Developer",
                "ThoughtWorks",
                "Tech",
                "Junior",
                Collections.emptyList());

        assertThat(expected).isEqualToIgnoringGivenFields(actualJob, "id");
    }
}
