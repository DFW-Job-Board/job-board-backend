package org.nsbedfw.jobboard.controllers;

import org.nsbedfw.jobboard.controllers.requests.CandidateRequest;
import org.nsbedfw.jobboard.domain.Candidate;
import org.nsbedfw.jobboard.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public void addCandidate(@RequestBody CandidateRequest candidateRequest) {
        candidateService.addCandidate(candidateRequest.toCandidate());
    }

    @GetMapping
    public List<Candidate> getCandidates() {
        return candidateService.getAllCandidates();
    }

    @DeleteMapping
    public void deleteCandidate(@RequestParam String candidateId) {
        candidateService.delete(candidateId);
    }

}
