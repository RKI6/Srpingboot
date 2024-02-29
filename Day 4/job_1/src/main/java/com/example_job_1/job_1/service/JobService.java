package com.example_job_1.job_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example_job_1.job_1.model.Job;
import com.example_job_1.job_1.repository.JobRepo;

@Service
public class JobService {
    private JobRepo jobRepo;
    public JobService(JobRepo jobRepo)
    {
        this.jobRepo = jobRepo;
    }
    public boolean saveJob(Job job)
    {
        try {
            jobRepo.save(job);
        } catch (Exception e) {
           System.out.println("\nException");
           System.out.println(e.getMessage());
           System.out.println("\nException");
           return false;
        }
        return true;
    }
    public Optional<Job> getJobById(int jobId)
    {
        return jobRepo.findById(jobId);
    }
    public List<Job> getAllJob()
    {
        return jobRepo.findAll();
    }
}
