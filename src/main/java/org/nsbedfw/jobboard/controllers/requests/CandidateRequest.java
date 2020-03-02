package org.nsbedfw.jobboard.controllers.requests;

import org.nsbedfw.jobboard.domain.Candidate;

import java.util.UUID;

public final class CandidateRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String industry;
    private final String skillLevel;

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getIndustry() {
        return industry;
    }

    public String getSkillLevel() {
        return skillLevel;
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


