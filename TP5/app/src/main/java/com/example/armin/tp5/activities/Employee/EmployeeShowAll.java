package com.example.armin.tp5.activities.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.armin.tp5.R;
import com.example.armin.tp5.domain.Employee.EmployeeData;
import com.example.armin.tp5.repository.Employee.Impl.EmployeeRepositoryImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Armin on 2016-06-07.
 */
public class EmployeeShowAll extends AppCompatActivity{
    private Set<EmployeeData> personSet;
    private ArrayAdapter adapter;
    //private ArrayAdapter adapter1;
    private ListView listView;
    private String[] names;
    //private String[] id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_showall);

        EmployeeRepositoryImpl personRepository = new EmployeeRepositoryImpl(this.getApplicationContext());

        personSet = new HashSet<>();

        personSet = personRepository.findAll();

        Iterator<EmployeeData> itPerson = personSet.iterator();

        if(personSet.size() > 0) {

            names = new String[personSet.size()];
            // id = new String[personSet.size()];
            int i = 0;

            while(itPerson.hasNext()) {
                // id[i]= String.valueOf(itPerson.next().getId());
                names[i] = itPerson.next().getDetails().getName();
                i++;
            }

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
            //adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,id);

            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
            //listView.setAdapter(adapter1);
        }
        else{
            Toast.makeText(EmployeeShowAll.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    public void returntoHome(View view) {

        Intent i = new Intent(getApplicationContext(), EmployeeMenu.class);
        startActivity(i);

    }
}

