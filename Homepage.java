package com.example.inspire.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class Homepage extends AppCompatActivity {
    Button btn_reg,btn_view,btn_log;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

         btn_reg = (Button) findViewById(R.id.rgst);
         btn_log = (Button) findViewById(R.id.log);
        btn_view = (Button) findViewById(R.id.view);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,MainActivity.class);
                startActivity(intent);
            }
        });
         btn_log.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(Homepage.this,LoginPage.class);
                 startActivity(intent);
             }
         });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,Viewpage.class);
                startActivity(intent);
            }
        });
        }

}
