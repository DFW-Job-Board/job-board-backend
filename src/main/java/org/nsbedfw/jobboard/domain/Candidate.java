package org.nsbedfw.jobboard.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Candidate {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String industry;
    private String skillLevel;
    private ArrayList<String> companies;

    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", industry='" + industry + '\'' +
                ", skillLevel='" + skillLevel + '\'' +
                ", companies=" + companies +
                '}';
    }
}

