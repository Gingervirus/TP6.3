package com.example.armin.tp5.activities.Employee;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.armin.tp5.R;
import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.factories.Employee.EmployeeFactory;
import com.example.armin.tp5.services.Employee.DeleteEmployeeService;

/**
 * Created by Armin on 2016-06-05.
 */
public class EmployeeDeleteActivity extends AppCompatActivity{
    DeleteEmployeeService deleteEmployeeService;
    EditText delete;
    boolean isbound = false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_delete);
    }

    public void deleteEmployee(View v)
    {
        delete = (EditText)findViewById(R.id.txtEmployeeId);
        Long id = Long.parseLong(delete.toString());
        EmployeeFactory emp = new EmployeeFactory(id, null , 0, null, null, null, null, null, null, null);
        EmployeeData e = emp.getEmployee();
        deleteEmployeeService.deleteEmployee(e);
    }

    private ServiceConnection insertConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DeleteEmployeeService.MyLocalBinder binder = (DeleteEmployeeService.MyLocalBinder) service;
            deleteEmployeeService = binder.getService();
            isbound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isbound = false;
        }
    };
}
