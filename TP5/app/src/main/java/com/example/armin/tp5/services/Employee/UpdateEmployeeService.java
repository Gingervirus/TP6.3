package com.example.armin.tp5.services.Employee;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.armin.tp5.conf.util.App;
import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.repository.Employee.EmployeeRepository;
import com.example.armin.tp5.repository.Employee.Impl.EmployeeRepositoryImpl;

public class UpdateEmployeeService extends Service {
    private EmployeeRepository repo;
    private final IBinder updateEmployee = new MyLocalBinder();

    public UpdateEmployeeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return updateEmployee;
    }

    public String updateEmployee(EmployeeData emp)
    {
        repo = new EmployeeRepositoryImpl(App.getAppContext());
        repo.update(emp);
        return "UPDATED";
    }

    public class MyLocalBinder extends Binder
    {
        public UpdateEmployeeService getService()
        {
            return UpdateEmployeeService.this;
        }
    }
}
