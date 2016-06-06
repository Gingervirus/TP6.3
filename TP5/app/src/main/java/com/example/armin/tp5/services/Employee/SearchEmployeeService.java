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
public class SearchEmployeeService extends Service {
    private EmployeeRepository repo;
    private final IBinder searchEmployee = new MyLocalBinder();

    public SearchEmployeeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return searchEmployee;
    }

    public EmployeeData searchEmployee(Long emp)
    {
        repo = new EmployeeRepositoryImpl(App.getAppContext());
        return repo.findById(emp);
    }

    public class MyLocalBinder extends Binder
    {
        public SearchEmployeeService getService()
        {
            return SearchEmployeeService.this;
        }
    }
}
