package org.nsbedfw.jobboard.controllers.requests;

import org.junit.jupiter.api.Test;
import org.nsbedfw.jobboard.domain.Candidate;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CandidateRequestTest {

    @Test
    void shouldTransformToCandidate() {
        CandidateRequest candidateRequest = new CandidateRequest(
                "Goodness",
                "Daramola",
                "email@test.com",
                "Software",
                "entry"
        );

        Candidate actualCandidate = candidateRequest.toCandidate();

        Candidate expected = new Candidate(
                UUID.randomUUID(),
                "Goodness",
                "Daramola",
                "email@test.com",
                "Software",
                "entry",
                null
        );
        assertThat(expected).isEqualToIgnoringGivenFields(actualCandidate, "id");
    }
}