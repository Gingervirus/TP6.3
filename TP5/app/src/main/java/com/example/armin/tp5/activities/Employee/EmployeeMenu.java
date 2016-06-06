package com.example.armin.tp5.activities.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.armin.tp5.R;

/**
 * Created by Armin on 2016-06-05.
 */
public class EmployeeMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_menu);
        Button btn_add = (Button)findViewById(R.id.btn_addEmployee);
    }

    public void addEmployee(View v)
    {
        Intent i = new Intent(EmployeeMenu.this, EmployeeAddActivity.class);
        startActivity(i);
    }

    public void updateEmployee(View v)
    {
        Intent i = new Intent(EmployeeMenu.this, EmployeeUpdateActivity.class);
        startActivity(i);
    }

    public void deleteEmployee(View v)
    {
        Intent i = new Intent(EmployeeMenu.this, EmployeeDeleteActivity.class);
        startActivity(i);
    }

    public void viewAllEmployee(View v)
    {
        Intent i = new Intent(EmployeeMenu.this, EmployeeViewAllActivity.class);
        startActivity(i);
    }

    public void searchEmployee(View v)
    {
        Intent i = new Intent(EmployeeMenu.this, EmployeeSearchActivity.class);
        startActivity(i);
    }
}
