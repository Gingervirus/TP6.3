package com.example.armin.tp5.factories.Job;

import com.example.armin.tp5.domain.Job.Job;
import com.example.armin.tp5.domain.Job.JobCleaner;
import com.example.armin.tp5.domain.Job.JobPrincipal;
import com.example.armin.tp5.domain.Job.JobSecretary;
import com.example.armin.tp5.domain.Job.JobTeacher;

/**
 * Created by Armin on 2016-04-06.
 */
public class JobFactory {
    public static String getJob(String employeeID)
    {
        String jobID = employeeID.substring(0,3);
        System.out.println(jobID);
        Job chain = setUpChain();
        return chain.handleRequest(jobID);
    }

    public static Job setUpChain()
    {
        Job c = new JobCleaner();
        Job s= new JobSecretary();
        Job t = new JobTeacher();
        Job p = new JobPrincipal();
        c.setNextJob(s);
        s.setNextJob(t);
        t.setNextJob(p);
        return c;
    }
}
