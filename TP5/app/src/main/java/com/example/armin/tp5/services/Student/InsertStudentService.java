package com.example.armin.tp5.services.Student;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.armin.tp5.conf.util.App;
import com.example.armin.tp5.domain.Student.StudentData;
import com.example.armin.tp5.repository.Student.Impl.StudentRepositoryImpl;
import com.example.armin.tp5.repository.Student.StudentRepository;

/**
 * Created by Armin on 2016-05-08.
 */
public class InsertStudentService extends Service {
    private StudentRepository repo;
    private final IBinder insertEmployee = new MyLocalBinder();

    public InsertStudentService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return insertEmployee;
    }

    public String insertStudent(StudentData studentData)
    {
        repo = new StudentRepositoryImpl(App.getAppContext());
        repo.save(studentData);
        return "INSERTED";
    }

    public class MyLocalBinder extends Binder
    {
        public InsertStudentService getService()
        {
            return InsertStudentService.this;
        }
    }
}
