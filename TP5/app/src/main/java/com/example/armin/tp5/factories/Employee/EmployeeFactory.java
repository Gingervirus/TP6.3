package com.example.armin.tp5.factories.Employee;

import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.domain.Employee.EmployeeDetails;
import com.example.armin.tp5.factories.Salary.SalaryFactory;
import com.example.armin.tp5.factories.WorkingHours.WorkingHoursFactory;

/**
 * Created by Armin on 2016-05-08.
 */
public class EmployeeFactory {

    public EmployeeData getEmployee(Long empNr, String sarsNr, double salary, String workingHours, String name, String lastName, String dob, String gender, String cell, String job)
    {
        EmployeeDetails details = new EmployeeDetails.Builder()
                .name(name)
                .lastName(lastName)
                .gender(gender)
                .cell(cell)
                .dob(dob)
                .build();
        EmployeeData emp = new EmployeeData.Builder()
                .empNr(empNr)
                .salary(Double.parseDouble(SalaryFactory.getSalary(job)))
                .workingHours(WorkingHoursFactory.getWorkingHours(job))
                .sarsNr(sarsNr)
                .employeeDetails(details)
                .job(job)
                .build();
        return emp;
    }
}
