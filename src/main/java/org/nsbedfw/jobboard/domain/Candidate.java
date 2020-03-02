package org.nsbedfw.jobboard.domain;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

public final class Candidate {
    @Id
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String industry;
    private final String skillLevel;
    private final List<String> companies;

    public Candidate(
            UUID id,
            String firstName,
            String lastName,
            String email,
            String industry,
            String skillLevel,
            List<String> companies
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.industry = industry;
        this.skillLevel = skillLevel;
        this.companies = companies;
    }

    public UUID getId() {
        return id;
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

    public List<String> getCompanies() {
        return companies;
    }
}

