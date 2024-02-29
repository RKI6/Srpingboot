package com.example_job_1.job_1.model;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Job {
    @Id
    private int jobid;
    private String jobTitle;
    private int minSalary;
    private String jobDescription;
    private int maxSalary;
    @Autowired
    public Job(int jobid, String jobTitle, int minSalary, String jobDescription, int maxSalary) {
        this.jobid = jobid;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.jobDescription = jobDescription;
        this.maxSalary = maxSalary;
    }
    public Job() {
    }
    public int getJobid() {
        return jobid;
    }
    public void setJobid(int jobid) {
        this.jobid = jobid;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public int getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }
    public String getJobDescription() {
        return jobDescription;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    public int getMaxSalary() {
        return maxSalary;
    }
    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
    
}
