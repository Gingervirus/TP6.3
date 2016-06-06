package com.example.armin.tp5.activities.Employee;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.armin.tp5.R;
import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.factories.Employee.EmployeeFactory;
import com.example.armin.tp5.factories.Salary.SalaryFactory;
import com.example.armin.tp5.services.Employee.InsertEmployeeService;

public class EmployeeAddActivity extends AppCompatActivity {

    private Button btn_add;
    private RadioGroup jobGroup;
    InsertEmployeeService insertEmployeeService;
    boolean isbound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_add);
        Intent i = new Intent(this, InsertEmployeeService.class);
        btn_add = (Button)findViewById(R.id.btnAddEmployee);
        jobGroup =(RadioGroup)findViewById(R.id.jobGroup);
        bindService(i, insertConnection, Context.BIND_AUTO_CREATE);
    }

    public void addEmployee(View v)
    {
        EditText name = (EditText)findViewById(R.id.name);
        EditText surname = (EditText)findViewById(R.id.surname);
        EditText dob = (EditText)findViewById(R.id.txtDob);
        EditText gender = (EditText)findViewById(R.id.name);
        EditText cell = (EditText)findViewById(R.id.txtCell);
        EditText sars = (EditText)findViewById(R.id.txtSarsNr);
        RadioButton job;
        int selectedId = jobGroup.getCheckedRadioButtonId();
        job=(RadioButton)findViewById(selectedId);
        String salary = SalaryFactory.getSalary("TEA12319");
        EmployeeFactory emp = new EmployeeFactory(null, sars.toString(), 0, null, name.toString(), surname.toString(), dob.toString(), gender.toString(), cell.toString(), job.toString());
        EmployeeData e = emp.getEmployee();
        EmployeeData insert = insertEmployeeService.insertEmployee(e);
    }

    private ServiceConnection insertConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            InsertEmployeeService.MyLocalBinder binder = (InsertEmployeeService.MyLocalBinder) service;
            insertEmployeeService = binder.getService();
            isbound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isbound = false;
        }
    };

}
