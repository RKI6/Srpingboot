package com.example_job_1.job_1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example_job_1.job_1.model.Job;
import com.example_job_1.job_1.service.JobService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class JobController {
    private JobService jobService;
    public JobController(JobService jobService)
    {
        this.jobService =  jobService;
    }
    @PostMapping("api/job")
    public ResponseEntity postJob(@RequestBody Job job) {
        if(jobService.saveJob(job) == true )
        return new ResponseEntity<>(job , HttpStatus.CREATED);
        return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/api/job")
    public ResponseEntity getJob() {
        if(jobService.getAllJob().size() == 0)
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(jobService.getAllJob(),HttpStatus.CREATED);
    }
    @GetMapping("/api/job/{jobId}")
    public ResponseEntity getJob(@PathVariable ("jobId")int jobId) {
        Optional<Job> job = jobService.getJobById(jobId);
        
        if(job == null)
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(job,HttpStatus.CREATED);
        
    }
    
    
}
