package org.nsbedfw.jobboard.controllers;

import org.nsbedfw.jobboard.controllers.requests.JobRequest;
import org.nsbedfw.jobboard.domain.Job;
import org.nsbedfw.jobboard.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public void addJob(@RequestBody JobRequest jobRequest) {
        jobService.addJob(jobRequest.toJob());
    }

    @GetMapping
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }

    @DeleteMapping
    public void deleteJob(@RequestParam String jobId) {
        jobService.delete(jobId);
    }
}
