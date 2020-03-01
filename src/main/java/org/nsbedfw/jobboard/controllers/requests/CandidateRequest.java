package org.nsbedfw.jobboard.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String industry;
    private String skillLevel;
}


