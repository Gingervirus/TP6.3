package com.example.armin.tp5.domain.Job;

/**
 * Created by Armin on 2016-04-06.
 */
public abstract class Job {
    Job nextJob;

    public void setNextJob( Job nextJob) {
        this.nextJob = nextJob;
    }
    public abstract String handleRequest(String request);
}
