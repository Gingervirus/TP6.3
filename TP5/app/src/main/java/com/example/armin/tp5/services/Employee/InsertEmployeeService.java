package com.example.armin.tp5.services.Employee;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.armin.tp5.conf.util.App;
import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.repository.Employee.EmployeeRepository;
import com.example.armin.tp5.repository.Employee.Impl.EmployeeRepositoryImpl;

/**
 * Created by Armin on 2016-05-08.
 */
public class InsertEmployeeService extends Service {
    private EmployeeRepository repo;
    private final IBinder insertEmployee = new MyLocalBinder();

    public InsertEmployeeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return insertEmployee;
    }

    public EmployeeData insertEmployee(EmployeeData emp)
    {
        repo = new EmployeeRepositoryImpl(App.getAppContext());
        return repo.save(emp);
    }

    public class MyLocalBinder extends Binder
    {
        public InsertEmployeeService getService()
        {
            return InsertEmployeeService.this;
        }
    }
}
