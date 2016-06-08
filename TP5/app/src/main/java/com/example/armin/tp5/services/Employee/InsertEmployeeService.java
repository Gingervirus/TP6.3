package com.example.armin.tp5.services.Employee;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.repository.Employee.EmployeeRepository;
import com.example.armin.tp5.repository.Employee.Impl.EmployeeRepositoryImpl;

/**
 * Created by Armin on 2016-05-08.
 */
public class InsertEmployeeService extends Service implements InsertEmployee{
    private final IBinder insertEmployee = new MyLocalBinder();
    private EmployeeRepository repo;
    public InsertEmployeeService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return insertEmployee;
    }

    public String insertEmployee(EmployeeData emp)
    {
        if (true)
        {
           createEmployee(emp);
            return "ACTIVATED";
        }else
        {
            return "NOTACTIVATED";
        }

    }

    private EmployeeData createEmployee(EmployeeData entity)
    {
        repo = new EmployeeRepositoryImpl(this.getApplicationContext());
        return repo.save(entity);
    }

    public class MyLocalBinder extends Binder
    {
        public InsertEmployeeService getService()
        {
            return InsertEmployeeService.this;
        }
    }
}
