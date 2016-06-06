package com.example.armin.tp5.factories.WorkingHours;

import com.example.armin.tp5.domain.WorkingHours.WorkingHours;
import com.example.armin.tp5.domain.WorkingHours.WorkingHoursCleaner;
import com.example.armin.tp5.domain.WorkingHours.WorkingHoursPrincipal;
import com.example.armin.tp5.domain.WorkingHours.WorkingHoursSecratary;
import com.example.armin.tp5.domain.WorkingHours.WorkingHoursTeacher;

/**
 * Created by Armin on 2016-04-06.
 */
public class WorkingHoursFactory {
    public static String getWorkingHours(String employeeType)
    {
        WorkingHours chain = setUpChain();
        return chain.handleRequest(employeeType);
    }

    public static WorkingHours setUpChain()
    {
        WorkingHours c = new WorkingHoursCleaner();
        WorkingHours s= new WorkingHoursSecratary();
        WorkingHours t = new WorkingHoursTeacher();
        WorkingHours p = new WorkingHoursPrincipal();
        c.setNextWorkingHours(s);
        s.setNextWorkingHours(t);
        t.setNextWorkingHours(p);
        return c;
    }
}
