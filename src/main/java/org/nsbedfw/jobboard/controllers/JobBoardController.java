package org.nsbedfw.jobboard.controllers;

import org.nsbedfw.jobboard.controllers.requests.CandidateRequest;
import org.nsbedfw.jobboard.domain.Candidate;
import org.nsbedfw.jobboard.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("candidates")
public class JobBoardController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addCandidate(@RequestBody CandidateRequest candidateRequest) {
        candidateService.addCandidate(candidateRequest.toCandidate());
    }

    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    public List<Candidate> getCandidates() {
        return candidateService.getAllCandidates();
    }

    @DeleteMapping(consumes = APPLICATION_JSON_VALUE)
    public void deleteCandidate(@RequestParam String candidateId) {
        candidateService.delete(candidateId);
    }

}
