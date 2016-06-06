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
public class DeleteEmployeeService extends Service {
    private EmployeeRepository repo;
    private final IBinder deleteEmployee = new MyLocalBinder();

    public DeleteEmployeeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return deleteEmployee;
    }

    public EmployeeData deleteEmployee(EmployeeData emp)
    {
        repo = new EmployeeRepositoryImpl(App.getAppContext());
        return repo.delete(emp);
    }

    public class MyLocalBinder extends Binder
    {
        public DeleteEmployeeService getService()
        {
            return DeleteEmployeeService.this;
        }
    }
}
