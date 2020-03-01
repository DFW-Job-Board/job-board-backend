package org.nsbedfw.jobboard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private String industry;
    private String skillLevel;
    private ArrayList<String> companies;
}
