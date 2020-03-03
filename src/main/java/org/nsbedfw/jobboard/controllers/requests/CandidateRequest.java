package org.nsbedfw.jobboard.controllers.requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.nsbedfw.jobboard.domain.Candidate;

import java.util.UUID;

@Data
@NoArgsConstructor
public final class CandidateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String industry;
    private String skillLevel;

    public CandidateRequest(
            String firstName,
            String lastName,
            String email,
            String industry,
            String skillLevel
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.industry = industry;
        this.skillLevel = skillLevel;
    }

    public Candidate toCandidate() {
        return new Candidate(
                UUID.randomUUID(),
                firstName,
                lastName,
                email,
                industry,
                skillLevel,
                null
        );
    }
}


