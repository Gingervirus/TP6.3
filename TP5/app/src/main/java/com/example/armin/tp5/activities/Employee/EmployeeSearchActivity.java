package com.example.armin.tp5.activities.Employee;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.armin.tp5.R;
import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.services.Employee.SearchEmployeeService;

/**
 * Created by Armin on 2016-06-05.
 */
public class EmployeeSearchActivity extends AppCompatActivity {
    SearchEmployeeService searchEmployeeService;
    boolean isbound;
    Long id;
    Button search;
    EditText employeeId;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_search);
        search = (Button)findViewById(R.id.btnSearchEmployee);
    }

    public void searchEmployee(View v)
    {
        employeeId = (EditText)findViewById(R.id.txtEmployeeId);
        id = Long.parseLong(employeeId.toString());
        EmployeeData entity = searchEmployeeService.searchEmployee(id);
        TextView lblname = (TextView) findViewById(R.id.lbl_name);
    }

    private ServiceConnection searchConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            SearchEmployeeService.MyLocalBinder binder = (SearchEmployeeService.MyLocalBinder) service;
            searchEmployeeService = binder.getService();
            isbound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isbound = false;
        }
    };

}
