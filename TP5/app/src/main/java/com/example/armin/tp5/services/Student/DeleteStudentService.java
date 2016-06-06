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
public class DeleteStudentService extends Service {
    private StudentRepository repo;
    private final IBinder deleteStudent = new MyLocalBinder();

    public DeleteStudentService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return deleteStudent;
    }

    public String deleteStudent(StudentData emp)
    {
        repo = new StudentRepositoryImpl(App.getAppContext());
        repo.delete(emp);
        return "DELETED";
    }

    public class MyLocalBinder extends Binder
    {
        public DeleteStudentService getService()
        {
            return DeleteStudentService.this;
        }
    }
}
