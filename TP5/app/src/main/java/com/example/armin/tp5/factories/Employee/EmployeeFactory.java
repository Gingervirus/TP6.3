package com.example.armin.tp5.factories.Employee;

import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.domain.Employee.EmployeeDetails;
import com.example.armin.tp5.factories.Salary.SalaryFactory;
import com.example.armin.tp5.factories.WorkingHours.WorkingHoursFactory;

/**
 * Created by Armin on 2016-05-08.
 */
public class EmployeeFactory {
    private Long empNr;
    private String sarsNr;
    private double salary;
    private String workingHours;
    private String name;
    private String lastName;
    private String dob;
    private String gender;
    private String cell;
    private String job;

    public EmployeeFactory(Long empNr, String sarsNr, double salary, String workingHours, String name, String lastName, String dob, String gender, String cell, String job) {
        this.empNr = empNr;
        this.sarsNr = sarsNr;
        this.salary = salary;
        this.workingHours = workingHours;
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.cell = cell;
        this.job = job;
    }

    public EmployeeFactory() {
    }

    public void setEmpNr(Long empNr) {
        this.empNr = empNr;
    }

    public void setSarsNr(String sarsNr) {
        this.sarsNr = sarsNr;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public EmployeeData getEmployee()
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
                .build();
        return emp;
    }
}
