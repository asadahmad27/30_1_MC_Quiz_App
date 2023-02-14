package com.example.myapplication20230130;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class View_Layout extends AppCompatActivity {

    DBHAndler db;
    ListView lstv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_layout);

        db = new DBHAndler(this);
        lstv = findViewById(R.id.listView);

        List<Student> studentsList = db.getData();

        ArrayList<String> students = new ArrayList<String>();
        for(int i = 0; i < studentsList.size(); i++) {
            students.add(studentsList.get(i).toString());
        }

        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);

        lstv.setAdapter(adp);
    }
}