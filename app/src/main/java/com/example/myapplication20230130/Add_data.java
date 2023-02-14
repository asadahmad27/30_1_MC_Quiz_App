package com.example.myapplication20230130;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Add_data extends AppCompatActivity {

    TextView date;
    RadioButton fr1, fr2;
    RadioButton zr1, zr2;
    RadioButton ar1, ar2;
    RadioButton mr1, mr2;
    RadioButton ir1, ir2;
    TextView fr, zr, ar, mr, ir;
    DBHAndler db;

    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        date = findViewById(R.id.editTextDate2);

        fr1 = findViewById(R.id.radioButton2);
        fr2 = findViewById(R.id.radioButton3);


        zr1 = findViewById(R.id.radioButton5);
        zr2 = findViewById(R.id.radioButton6);


        ar1 = findViewById(R.id.radioButton8);
        ar2 = findViewById(R.id.radioButton9);


        mr1 = findViewById(R.id.radioButton11);
        mr2 = findViewById(R.id.radioButton12);


        ir1 = findViewById(R.id.radioButton14);
        ir2 = findViewById(R.id.radioButton15);

        fr = findViewById(R.id.editTextTextPersonName);
        zr = findViewById(R.id.editTextTextPersonName3);
        ar = findViewById(R.id.editTextTextPersonName4);
        mr = findViewById(R.id.editTextTextPersonName5);
        ir = findViewById(R.id.editTextTextPersonName6);

        add = findViewById(R.id.add);
        db = new DBHAndler(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fajarOffered = fr1.isChecked() ? "With Jamaat" : fr2.isChecked() ? "AT Home" : "SORRY";
                String zuhrOffered = zr1.isChecked() ? "With Jamaat" : zr2.isChecked() ? "AT Home" : "SORRY";
                String asarOffered = ar1.isChecked() ? "With Jamaat" : ar2.isChecked() ? "AT Home" : "SORRY";
                String maghribOffered = mr1.isChecked() ? "With Jamaat" : mr2.isChecked() ? "AT Home" : "SORRY";
                String ishaOffered = ir1.isChecked() ? "With Jamaat" : ir2.isChecked() ? "AT Home" : "SORRY";

                String fc = fr1.isChecked() || fr2.isChecked() && fr.toString() != ""? fr.getText().toString(): "0";
                String zc = zr1.isChecked() || zr2.isChecked() && zr.toString() != ""? zr.getText().toString(): "0";
                String ac = ar1.isChecked() || ar2.isChecked() && ar.toString() != ""? ar.getText().toString(): "0";
                String mc = mr1.isChecked() || mr2.isChecked() && mr.toString() != ""? mr.getText().toString(): "0";
                String ic = ir1.isChecked() || ir2.isChecked() && ir.toString() != ""? ir.getText().toString(): "0";

                Student newStudentData = new Student(date.getText().toString(), fajarOffered, zuhrOffered, asarOffered,
                        maghribOffered, ishaOffered,fc, zc, ac, mc, ic);

                db.AddStudentRecord(newStudentData);

                Toast toast = new Toast(Add_data.this);

                toast.setText("Data Added!");
                toast.setDuration(Toast.LENGTH_LONG);

                toast.show();
            }
        });
    }
}