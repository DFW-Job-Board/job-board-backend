package org.nsbedfw.jobboard.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nsbedfw.jobboard.domain.Candidate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String industry;
    private String skillLevel;

    public Candidate toCandidate() {
        Candidate candidate = new Candidate();
        candidate.setId(id);
        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        candidate.setEmail(email);
        candidate.setIndustry(industry);
        candidate.setSkillLevel(skillLevel);

        return candidate;
    }
}


