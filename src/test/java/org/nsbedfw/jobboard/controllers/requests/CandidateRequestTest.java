package org.nsbedfw.jobboard.controllers.requests;

import org.junit.jupiter.api.Test;
import org.nsbedfw.jobboard.domain.Candidate;

import static org.assertj.core.api.Assertions.assertThat;

class CandidateRequestTest {

    @Test
    void shouldTransformToCandidate() {
        CandidateRequest candidateRequest = new CandidateRequest("id", "Goodness", "Daramola", "email@test.com", "Software", "entry");
        Candidate expected = new Candidate("id", "Goodness", "Daramola", "email@test.com", "Software", "entry", null);

        Candidate actualCandidate = candidateRequest.toCandidate();

        assertThat(expected).isEqualToComparingFieldByField(actualCandidate);
    }
}