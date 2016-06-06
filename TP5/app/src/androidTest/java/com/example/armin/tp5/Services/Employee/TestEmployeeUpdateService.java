package com.example.armin.tp5.Services.Employee;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.domain.Employee.EmployeeDetails;
import com.example.armin.tp5.factories.Salary.SalaryFactory;
import com.example.armin.tp5.factories.WorkingHours.WorkingHoursFactory;
import com.example.armin.tp5.services.Employee.UpdateEmployeeService;

import junit.framework.Assert;

/**
 * Created by Armin on 2016-05-08.
 */
public class TestEmployeeUpdateService extends AndroidTestCase{
    UpdateEmployeeService updateService;
    boolean isBound = false;

    public void setUp() throws Exception {
        super.setUp();
        Intent serviceIntent = new Intent(this.getContext(), UpdateEmployeeService.class);
        this.getContext().bindService(serviceIntent,connection, Context.BIND_AUTO_CREATE);
    }
    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            UpdateEmployeeService.MyLocalBinder binder = (UpdateEmployeeService.MyLocalBinder) service;
            updateService = binder.getService();
            try {
                testUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }

        public void testUpdate() throws Exception {
            EmployeeDetails details = new EmployeeDetails.Builder()
                    .name("Armin")
                    .lastName("Wentzel")
                    .gender("Male")
                    .cell("0764805005")
                    .dob("21/06/1995")
                    .build();
            EmployeeData createEntity = new EmployeeData.Builder()
                    .salary(Double.parseDouble(SalaryFactory.getSalary("TEA11111")))
                    .workingHours(WorkingHoursFactory.getWorkingHours("Teacher"))
                    .sarsNr("2314565346")
                    .employeeDetails(details)
                    .build();
            EmployeeData updateEntity = new EmployeeData.Builder()
                    .copy(createEntity)
                    .workingHours("12H00-17H00")
                    .build();

            Assert.assertEquals("UPDATED", updateService.updateEmployee(updateEntity));
        }
    };

}
