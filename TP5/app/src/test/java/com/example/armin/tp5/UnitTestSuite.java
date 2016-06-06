package com.example.armin.tp5;

import com.example.armin.tp5.Detention.TestDetention;
import com.example.armin.tp5.Employee.TestEmployee;
import com.example.armin.tp5.Grading.TestGradingFactory;
import com.example.armin.tp5.Job.TestJobFactory;
import com.example.armin.tp5.Salary.TestSalaryFactory;
import com.example.armin.tp5.Student.TestStudent;
import com.example.armin.tp5.WorkingHours.TestWorkingHours;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({TestEmployee.class, TestDetention.class, TestGradingFactory.class, TestJobFactory.class, TestSalaryFactory.class, TestStudent.class, TestWorkingHours.class})
public class UnitTestSuite {}