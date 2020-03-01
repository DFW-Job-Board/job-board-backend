package org.nsbedfw.jobboard.testUtilities;

import org.nsbedfw.jobboard.domain.Candidate;

import java.util.Collections;

public class DummyData {


    public static Candidate dummyCandidate() {
        return new Candidate("id",
                "Goodness",
                "Daramola",
                "email@test.com",
                "Software",
                "entry",
                Collections.emptyList());
    }

}
