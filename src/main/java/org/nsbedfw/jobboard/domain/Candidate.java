package org.nsbedfw.jobboard.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public final class Candidate {
    @Id
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String industry;
    private final String skillLevel;
    private final List<String> companies;

    public Candidate(
            String id,
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

    public String getId() {
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

