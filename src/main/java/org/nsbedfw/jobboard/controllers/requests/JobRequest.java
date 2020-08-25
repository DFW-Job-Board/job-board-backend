package org.nsbedfw.jobboard.controllers.requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.nsbedfw.jobboard.domain.Job;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class JobRequest {
    private String title;
    private String companyName;
    private String industry;
    private String skillLevel;
    private List<String> skills;

    public JobRequest(
            String title,
            String companyName,
            String industry,
            String skillLevel,
            List<String> skills
    ) {
        this.title = title;
        this.companyName = companyName;
        this.industry = industry;
        this.skillLevel = skillLevel;
        this.skills = skills;
    }

    public Job toJob() {
        return new Job(
                UUID.randomUUID(),
                title,
                companyName,
                industry,
                skillLevel,
                skills
        );
    }
}
