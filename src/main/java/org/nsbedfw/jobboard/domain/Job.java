package org.nsbedfw.jobboard.domain;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

public class Job {

    @Id
    private final UUID id;
    private final String title;
    private final String companyName;
    private final String industry;
    private final String skillLevel;
    private final List<String> skills;

    public Job(
            UUID id,
            String title,
            String companyName,
            String industry,
            String skillLevel,
            List<String> skills
    ) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
        this.industry = industry;
        this.skillLevel = skillLevel;
        this.skills = skills;
    }

    public UUID getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTitle() {
        return title;
    }

    public String getIndustry() {
        return industry;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public List<String> getSkills() {
        return skills;
    }
}
