package org.nsbedfw.jobboard.controllers;

import org.nsbedfw.jobboard.controllers.requests.CandidateRequest;
import org.nsbedfw.jobboard.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("candidate")
public class JobBoardController {

    @Autowired
    private CandidateService candidateService;


    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addCandidate(@RequestBody CandidateRequest candidateRequest){
        candidateService.addCandidate(candidateRequest);
    }

}
