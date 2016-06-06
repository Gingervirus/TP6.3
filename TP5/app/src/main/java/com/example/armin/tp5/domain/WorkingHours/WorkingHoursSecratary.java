package com.example.armin.tp5.domain.WorkingHours;

/**
 * Created by Armin on 2016-04-06.
 */
public class WorkingHoursSecratary extends WorkingHours {
    @Override
    public String handleRequest(String request) {
        if (request.equals("Secratary")) {
            return "08H00-16H30";
        } else {
            if (nextWorkingHours != null) {
                return nextWorkingHours.handleRequest(request);
            }
            return "Incorrect Job description";
        }
    }
}
