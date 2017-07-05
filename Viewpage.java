package com.example.inspire.myapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inspire on 20/05/2017.
 */
public class Viewpage extends AppCompatActivity {
    RecyclerView rcview;
    LinearLayoutManager manager;
    DBHelper db;
    List<Employeelist>employeelists;
    Cursor resultSet;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpage);
        rcview = (RecyclerView) findViewById(R.id.rvMain);
        rcview.setLayoutManager(new LinearLayoutManager(this));
        db = new DBHelper(this);
        employeelists = new ArrayList<Employeelist>();
        resultSet = (Cursor) db.getData();

        try {
            if (resultSet!=null){
                resultSet.moveToFirst();
                do {
                    employeelists.add(new Employeelist(resultSet.getString(0),resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
                }while (resultSet.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(employeelists != null || employeelists.size() > 0){
            adapter=new RecyclerViewAdapter();
            rcview.setAdapter(adapter);
        }

    }

   public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewAdapter>{

       @Override
       public RecyclerViewAdapter.CustomViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, null);
           CustomViewAdapter viewHolder = new CustomViewAdapter(view);
           return viewHolder;
       }

       @Override
       public void onBindViewHolder(RecyclerViewAdapter.CustomViewAdapter holder, int position) {

           holder.name.setText(employeelists.get(position).name);
           holder.dob.setText(employeelists.get(position).dob);
       }

       @Override
       public int getItemCount() {
           int length= 0;
           if(resultSet!=null){
               length = employeelists.size();
           }
           return length;
       }

       public class CustomViewAdapter extends RecyclerView.ViewHolder {

           TextView name,dob;
           public CustomViewAdapter(View itemView) {
               super(itemView);

               name = (TextView) itemView.findViewById(R.id.txt_name);
               dob = (TextView) itemView.findViewById(R.id.txt_dob);
           }
       }
   }



}
