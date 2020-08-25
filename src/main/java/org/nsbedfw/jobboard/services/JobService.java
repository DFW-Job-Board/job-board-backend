package org.nsbedfw.jobboard.services;

import org.nsbedfw.jobboard.domain.Job;
import org.nsbedfw.jobboard.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public void addJob(Job job) {
        jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public void delete(String jobId) {
        jobRepository.deleteById(UUID.fromString(jobId));
    }
}
