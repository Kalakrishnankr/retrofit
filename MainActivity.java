package com.example.inspire.myapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText name, lname, dob, doj, salary,usernm,passwd;
    TextView dpmt, post;
    Button reg;
    Spinner sp1, sp2;
    Calendar myCalendar = Calendar.getInstance();
    String nm;
    String ln;
    String dateb;
    String datej;
    String spinner,un,pd;
    String spinner1,sal;
    DBHelper dhb;
    Button btn_view;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dhb = new DBHelper(this);

        name = (EditText) findViewById(R.id.nm);
        lname = (EditText) findViewById(R.id.ln);
        dob = (EditText) findViewById(R.id.dob);
        doj = (EditText) findViewById(R.id.doj);
        dpmt = (TextView) findViewById(R.id.depart);
        post = (TextView) findViewById(R.id.position);
        sp1 = (Spinner) findViewById(R.id.spinner1);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        reg = (Button) findViewById(R.id.btn_register);
        salary =(EditText) findViewById(R.id.sala);
        btn_view = (Button) findViewById(R.id.btn_view);
        usernm =(EditText) findViewById(R.id.un);
        passwd = (EditText) findViewById(R.id.pwd);
        List<String> department = new ArrayList<String>();
        department.add("Health");
        department.add("Science");
        department.add("Insurance");
        department.add("Management");
        department.add("IT");
        department.add("Cultural");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, department);
        sp1.setAdapter(adapter);

        List<String> position = new ArrayList<String>();
        position.add("Developer");
        position.add("Tester");
        position.add("Team Leader");
        position.add("HR");
        position.add("CEO");
        position.add("Director");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, position);
        sp2.setAdapter(adapter1);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                dob.setText(sdf.format(myCalendar.getTime()));
            }

        };
        final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                doj.setText(sdf.format(myCalendar.getTime()));
            }

        };

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        doj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nm = name.getText().toString();
                ln = lname.getText().toString();
                dateb = dob.getText().toString();
                datej = doj.getText().toString();
                sal = salary.getText().toString();
                spinner = sp1.getSelectedItem().toString();
                spinner1 = sp2.getSelectedItem().toString();
                un =usernm.getText().toString();
                pd = passwd.getText().toString();


                if (name.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Please enter your name",Toast.LENGTH_SHORT).show();
                }else if (lname.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Please enter our lastname",Toast.LENGTH_SHORT).show();
                }else if(salary.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Please enter our salary",Toast.LENGTH_SHORT).show();
                }else {

                    dhb.insertTable(nm,ln,dateb,datej,sal,spinner,spinner1,un,pd);
                    if(true){
                        Toast.makeText(MainActivity.this,"Sucessfully Insert",Toast.LENGTH_SHORT).show();
                        name.setText("");
                        lname.setText("");
                        dob.setText("");
                        doj.setText("");
                        salary.setText("");
                        usernm.setText("");
                        passwd.setText("");
                    }else {
                        Toast.makeText(MainActivity.this,"Retry",Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Viewpage.class);
                startActivity(intent);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }


}
