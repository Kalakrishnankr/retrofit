package com.example.inspire.myapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by inspire on 12/06/2017.
 */
public class LoginPage extends AppCompatActivity {

    Button login;
    EditText unm,pwd;
    String un,pd;
    DBHelper db;
    Cursor resultSet;
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setContentView(R.layout.loginpage);

        unm = (EditText) findViewById(R.id.unm);
        pwd = (EditText) findViewById(R.id.psd);
        login =(Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                un = unm.getText().toString();
                pd = pwd.getText().toString();

                resultSet = db.login(un,pd);
                try {
                    if (resultSet!=null)
                    {
                        if (resultSet.getCount() <0){


                            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Username Password Incorrect",Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });
    }
}
