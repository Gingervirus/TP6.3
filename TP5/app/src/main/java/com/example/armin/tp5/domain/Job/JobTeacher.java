package com.example.armin.tp5.domain.Job;

/**
 * Created by Armin on 2016-04-06.
 */
public class JobTeacher extends Job {
    @Override
    public String handleRequest(String request) {
        if (request.equals("TEA")) {
            return "teacher";
        } else {
            if (nextJob != null) {
                return nextJob.handleRequest(request);
            }
            return "That employee Nr does not exist! That person does not have a job";
        }
    }
}