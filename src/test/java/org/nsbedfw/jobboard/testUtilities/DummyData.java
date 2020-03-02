package org.nsbedfw.jobboard.testUtilities;

import org.nsbedfw.jobboard.domain.Candidate;

import java.util.Collections;
import java.util.UUID;

public class DummyData {


    public static Candidate dummyCandidate() {
        return new Candidate(
                UUID.randomUUID(),
                "Goodness",
                "Daramola",
                "email@test.com",
                "Software",
                "entry",
                Collections.emptyList());
    }

}
